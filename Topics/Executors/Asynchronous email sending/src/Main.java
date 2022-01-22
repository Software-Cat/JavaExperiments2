import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Do not change it
interface MailSender {

    void send(String message);
}

class Main {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    // Do not change it
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int messageCounts = scanner.nextInt();
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < messageCounts; ++i) {
            messages.add(scanner.next());
        }

        MailSender sender = new MockMailSender();
        asyncSend(sender, messages);
    }

    static void asyncSend(MailSender sender, List<String> messages) {
        // TODO
        for (String message : messages) {
            executor.submit(() -> sender.send(message));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(8, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
        }
    }
}

// The class simulates mail sending
// Do not change it
class MockMailSender implements MailSender {

    public void send(String message) {
        System.out.println("Message " + message + " was sent");
    }
}
