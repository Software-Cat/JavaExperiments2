import java.util.*;
import java.util.concurrent.*;

class FutureUtils {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        List<Callable<Integer>> callables = new ArrayList<>();
        for (Future<Callable<Integer>> future : items) {
            try {
                callables.add(future.get());
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
        Collections.reverse(callables);

        Deque<Integer> results = new ArrayDeque<>();
        for (Callable<Integer> callable : callables) {
            try {
                results.add(callable.call());
            } catch (Exception ignored) {
            }
        }

        int sum = 0;
        for (int result : results) {
            sum += result;
        }

        return sum;
    }
}
