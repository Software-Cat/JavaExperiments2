import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            executor.submit(new PrintIfPrimeTask(number));
        }

        executor.shutdown();
    }
}

class PrintIfPrimeTask implements Runnable {

    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (isPrime(number)) {
            System.out.println(number);
        }
    }

    private boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}
