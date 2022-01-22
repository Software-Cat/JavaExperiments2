// You can experiment here, it won’t be checked

import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {

    private static final ConcurrentCounter counter = new ConcurrentCounter();

    private static final ExecutorService executor = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public static void main(String[] args) {
        executor.submit(new Incrementor(counter, 10000));
        executor.submit(new Incrementor(counter, 10000));

        executor.shutdown();
        try {
            boolean b = executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }
}

record Incrementor(ConcurrentCounter counter, int times) implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            counter.increment();
        }
    }
}

class ConcurrentCounter {

    private final AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ConcurrentCounter.class.getSimpleName() + "[", "]")
                .add("counter=" + counter)
                .toString();
    }
}
