package com.example.threads;

/**
 * Example: Creating a thread by implementing Runnable.
 * Pass the Runnable to a Thread object; better when you don't need to extend another class.
 */
public class RunnableExample implements Runnable {

    private final String name;

    public RunnableExample(String name) {
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
        Runnable r1 = new RunnableExample("Runnable-A");
        Runnable r2 = new RunnableExample("Runnable-B");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

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
