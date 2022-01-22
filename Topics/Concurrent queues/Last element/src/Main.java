import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class QueueUtils {

    public static synchronized int getLastNumber(Queue<Integer> target) {
        Deque<Integer> deque = new ArrayDeque<>(target);
        return deque.getLast();
    }
}
