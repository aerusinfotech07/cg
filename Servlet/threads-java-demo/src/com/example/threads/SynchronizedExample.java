package com.example.threads;

/**
 * Example: Synchronization to avoid race conditions when multiple threads
 * access shared data. Only one thread at a time can execute the synchronized block/method.
 */
public class SynchronizedExample {

    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample shared = new SynchronizedExample();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                shared.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter (expected 2000): " + shared.getCounter());
    }
}
