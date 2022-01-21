import java.util.Objects;

class NumbersThread extends Thread {

    private final Range<Integer> range;

    public NumbersThread(int from, int to) {
        range = new Range<>(from, to);
    }

    public static void main(String[] args) {
        new NumbersThread(2, 2).start();
    }

    @Override
    public void run() {
        for (int i = range.getFrom(); i <= range.getTo(); i++) {
            System.out.println(i);
        }
    }
}

class Range<T extends Number> {

    private T from;
    private T to;

    public Range(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public T getFrom() {
        return from;
    }

    public void setFrom(T from) {
        this.from = from;
    }

    public T getTo() {
        return to;
    }

    public void setTo(T to) {
        this.to = to;
    }
}
