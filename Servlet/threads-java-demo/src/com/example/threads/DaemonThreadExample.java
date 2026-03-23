package com.example.threads;

/**
 * Example: Daemon threads do not keep the JVM running.
 * When all non-daemon threads finish, the JVM exits and daemon threads are stopped.
 */
public class DaemonThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("Daemon working...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        System.out.println("Main thread sleeping 2 seconds...");
        Thread.sleep(2000);
        System.out.println("Main thread done. JVM will exit (daemon stops).");
    }
}
