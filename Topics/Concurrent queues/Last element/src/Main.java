import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class QueueUtils {

    public static synchronized int getLastNumber(Queue<Integer> target) {
        Deque<Integer> deque = new ArrayDeque<>(target);
        return deque.getLast();
    }
}
