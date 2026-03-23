package com.example.threads;

/**
 * Example: wait() and notify() for thread coordination.
 * Producer adds items; consumer takes them. Consumer waits when empty; producer notifies when it adds.
 */
public class WaitNotifyExample {

    private String message;
    private boolean available = false;

    public synchronized void produce(String msg) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        message = msg;
        available = true;
        notifyAll();
    }

    public synchronized String consume() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        available = false;
        notifyAll();
        return message;
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyExample box = new WaitNotifyExample();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                box.produce("Message-" + i);
                System.out.println("Produced: Message-" + i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                String msg = box.consume();
                System.out.println("Consumed: " + msg);
            }
        });

        consumer.start();
        producer.start();
        producer.join();
        consumer.join();
        System.out.println("Done.");
    }
}
