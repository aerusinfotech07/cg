# Java Threads Demo (no Maven)

Simple Java projects demonstrating **threads**: Thread class, Runnable, synchronization, wait/notify, ExecutorService, and daemon threads.

## Examples

| Class | Topic | What it does |
|-------|--------|--------------|
| **ThreadExample** | Thread class | Extends Thread, overrides run(), start() and join() |
| **RunnableExample** | Runnable | Implements Runnable, passes to Thread |
| **SynchronizedExample** | Synchronization | Two threads increment a shared counter with synchronized methods |
| **WaitNotifyExample** | wait/notify | Producer puts messages, consumer takes them |
| **ExecutorExample** | ExecutorService | Fixed thread pool, submit 4 tasks |
| **DaemonThreadExample** | Daemon threads | Daemon thread stops when main exits |

## Run

- **IDE:** Open as Java project, run `main` of any class.
- **Command line** (from project root):
  ```bash
  javac -d out src/com/example/threads/*.java
  java -cp out com.example.threads.ThreadExample
  java -cp out com.example.threads.RunnableExample
  # ... same for other classes
  ```

## Notes

See **NOTES.md** for concept explanations and line-by-line code explanation for each example.
