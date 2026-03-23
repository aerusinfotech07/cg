

## 1. Thread Class — Creating a Thread by Extending `Thread`

### Concept

- A **thread** is a separate path of execution. The JVM runs multiple threads concurrently.
- One way to define what a thread does: **extend `java.lang.Thread`** and **override `run()`**. The code inside `run()` runs in the new thread when you call **`start()`**.

### Important points

- **Do not call `run()` directly** if you want a new thread. Call **`start()`** so the JVM creates a new thread and then calls `run()` in that thread.
- **`Thread.sleep(millis)`** pauses the *current* thread for the given time; it can throw `InterruptedException` (e.g. when another thread interrupts this one).
- **`join()`** makes the calling thread wait until the target thread finishes.

### Code: `ThreadExample.java`

```java
public class ThreadExample extends Thread {
    private final String name;

    public ThreadExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " count: " + i + " ...");
            Thread.sleep(100);  // current thread sleeps 100 ms
        }
    }

    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample("Thread-A");
        ThreadExample t2 = new ThreadExample("Thread-B");
        t1.start();   // starts new thread, which runs run()
        t2.start();
        t1.join();    // main waits for t1 to finish
        t2.join();
        System.out.println("Main thread done.");
    }
}
```

**Explanation:**

- `ThreadExample` extends `Thread`, so each instance *is* a thread. The work is in `run()`.
- `t1.start()` and `t2.start()` start two threads; both run their `run()` method in parallel.
- `t1.join()` and `t2.join()` block the main thread until `t1` and `t2` finish, so "Main thread done." prints last.

---

## 2. Runnable — Creating a Thread by Implementing `Runnable`

### Concept

- **`Runnable`** is an interface with a single method: **`void run()`**.
- Another way to define thread work: **implement `Runnable`** and pass it to a **`new Thread(runnable)`**. Calling **`thread.start()`** runs `runnable.run()` in the new thread.

### Why use Runnable?

- In Java a class can extend only one class. If your class already extends something else, it cannot extend `Thread`. It can still implement `Runnable` and be passed to `Thread`.
- Separates “what to run” (Runnable) from “the thread” (Thread). Often preferred in modern code.

### Code: `RunnableExample.java`

```java
public class RunnableExample implements Runnable {
    private final String name;

    public RunnableExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " count: " + i + " ...");
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new RunnableExample("Runnable-A");
        Runnable r2 = new RunnableExample("Runnable-B");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main thread done.");
    }
}
```

**Explanation:**

- `RunnableExample` implements `Runnable`; the work is in `run()`.
- `new Thread(r1)` creates a thread that will execute `r1.run()` when started.
- `t1.start()` and `t2.start()` run the two `run()` methods in two threads. Behavior is similar to `ThreadExample`, but the task is defined by `Runnable`, not by extending `Thread`.

---

## 3. Synchronization — Protecting Shared Data

### Concept

- When **multiple threads** read and write the **same variable** (e.g. a counter), **race conditions** can occur: the final value can be wrong because one thread’s update is overwritten or lost.
- **Synchronization** ensures that only one thread at a time executes a **synchronized** method or block on a given object, so updates to shared state are not interleaved incorrectly.

### Keyword: `synchronized`

- **`synchronized` method:** The thread must acquire the **lock** of the object (e.g. `this`) before entering; other threads block until the lock is released.
- **`synchronized(obj) { ... }` block:** Same idea, but you specify the lock object explicitly.

### Code: `SynchronizedExample.java`

```java
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
```

**Explanation:**

- `counter` is shared: both threads call `shared.increment()` 1000 times each. Without synchronization, `counter++` (read–modify–write) can be interleaved and the result can be less than 2000.
- **`synchronized void increment()`** means only one thread can be inside `increment()` at a time for this object, so each increment is atomic from the threads’ view. The result is 2000.
- **`synchronized int getCounter()`** ensures we see a consistent value when reading.

---

## 4. wait() and notify() — Thread Coordination

### Concept

- **`wait()`** (on an object): the current thread **releases the lock** and **waits** until another thread calls **`notify()`** or **`notifyAll()`** on the same object (or until a timeout/interrupt). When it wakes up, it must re-acquire the lock before continuing.
- **`notify()`** / **`notifyAll()`**: wake one or all threads waiting on that object. They do not release the lock immediately; they run until they leave the synchronized block/method.
- These must be used inside a **synchronized** block or method; otherwise you get `IllegalMonitorStateException`.

### Typical use

- **Producer–consumer:** One thread produces data; another consumes it. If there’s no data, the consumer **waits**; when the producer adds data, it **notifies**. Often we use a **while** loop around `wait()` to re-check the condition after waking (in case of spurious wakeup or multiple consumers).

### Code: `WaitNotifyExample.java`

```java
public class WaitNotifyExample {
    private String message;
    private boolean available = false;

    public synchronized void produce(String msg) {
        while (available) {
            wait();  // wait until consumer has taken the message
        }
        message = msg;
        available = true;
        notifyAll();
    }

    public synchronized String consume() {
        while (!available) {
            wait();  // wait until producer has put a message
        }
        available = false;
        notifyAll();
        return message;
    }
    // main starts producer and consumer threads...
}
```

**Explanation:**

- **`produce(msg)`:** If `available` is true, the previous message wasn’t consumed yet, so the producer **waits**. Otherwise it sets `message`, sets `available = true`, and calls **`notifyAll()`** so the consumer can wake up.
- **`consume()`:** If `available` is false, there’s no message, so the consumer **waits**. Otherwise it clears `available`, notifies (so the producer can continue), and returns the message.
- The **while** around `wait()` is important: when a thread wakes up, it must re-check the condition (e.g. still no message / still full) and wait again if needed.

---

## 5. ExecutorService — Thread Pools

### Concept

- Instead of creating many **Thread** objects yourself, you can use **`ExecutorService`**: you **submit** tasks (Runnable or Callable), and the executor runs them using a **pool** of threads.
- Benefits: reuse of threads, controlled number of threads (e.g. fixed pool), and a clear API for shutdown.

### Common usage

- **`Executors.newFixedThreadPool(n)`** — pool of `n` threads.
- **`executor.submit(runnable)`** — submit a task.
- **`executor.shutdown()`** — no new tasks; existing tasks run to completion.
- **`executor.awaitTermination(timeout, unit)`** — block until all tasks finish or timeout.

### Code: `ExecutorExample.java`

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

for (int i = 1; i <= 4; i++) {
    final int taskId = i;
    executor.submit(() -> {
        System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
        Thread.sleep(200);
    });
}

executor.shutdown();
executor.awaitTermination(5, TimeUnit.SECONDS);
```

**Explanation:**

- **`newFixedThreadPool(2)`** creates a pool of 2 threads. Four tasks are submitted; they run two at a time on those two threads.
- **`submit(Runnable)`** queues the task; when a thread is free, it runs the task. We don’t create or start `Thread` ourselves.
- **`shutdown()`** stops accepting new tasks. **`awaitTermination()`** makes the main thread wait (up to 5 seconds) for all submitted tasks to finish.

---

## 6. Daemon Threads

### Concept

- **Daemon threads** are “helper” threads. The **JVM exits** when all **non-daemon** threads have finished. Daemon threads do not keep the JVM running; they are stopped when the JVM exits.
- Use daemon threads for background work that should not prevent the program from exiting (e.g. a simple background logger). Do not use them for work that must complete (e.g. writing critical data).

### Code: `DaemonThreadExample.java`

```java
Thread daemon = new Thread(() -> {
    while (true) {
        System.out.println("Daemon working...");
        Thread.sleep(500);
    }
});
daemon.setDaemon(true);
daemon.start();

Thread.sleep(2000);
System.out.println("Main thread done. JVM will exit (daemon stops).");
```

**Explanation:**

- **`setDaemon(true)`** must be called **before** **`start()`**. The daemon thread runs in a loop. When the main thread finishes after 2 seconds, the JVM exits and the daemon is stopped; we don’t need to stop it manually.

---

## Summary Table

| Topic            | Main idea |
|------------------|-----------|
| **Thread class** | Extend `Thread`, override `run()`, call `start()` to run in a new thread. |
| **Runnable**     | Implement `Runnable`, pass to `new Thread(runnable)`, call `start()`. |
| **synchronized** | Only one thread at a time in synchronized method/block; protects shared data. |
| **wait/notify**  | Coordination: wait() releases lock and waits; notify()/notifyAll() wake waiters. |
| **ExecutorService** | Submit tasks to a thread pool; no direct Thread creation. |
| **Daemon**       | Daemon threads don’t keep the JVM alive; set before start(). |

---

## How to Run (no Maven)

- From IDE: open the project, run the `main` method of any class (e.g. `ThreadExample`, `RunnableExample`, etc.).
- From command line (from project root, with `src` as source):
  ```text
  javac -d out src/com/example/threads/*.java
  java -cp out com.example.threads.ThreadExample
  java -cp out com.example.threads.RunnableExample
  java -cp out com.example.threads.SynchronizedExample
  java -cp out com.example.threads.WaitNotifyExample
  java -cp out com.example.threads.ExecutorExample
  java -cp out com.example.threads.DaemonThreadExample
  ```
