package com.example.threads;

/**
 * Example: Creating a thread by extending the Thread class.
 * Override run() with the code that should run in the new thread.
 */
public class ThreadExample extends Thread {

    private final String name;

    public ThreadExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " count: " + i + " (thread: " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample("Thread-A");
        ThreadExample t2 = new ThreadExample("Thread-B");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main thread done.");
    }
}
