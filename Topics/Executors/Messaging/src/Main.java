import java.util.concurrent.*;

/* Do not change this interface */
interface AsyncMessageSender {

    void sendMessages(Message[] messages);

    void stop();
}

/* Do not change this class */
class Message {

    public final String text;
    public final String from;
    public final String to;

    Message(String from, String to, String text) {
        this.text = text;
        this.from = from;
        this.to = to;
    }
}

class AsyncMessageSenderImpl implements AsyncMessageSender {

    private final int repeatFactor;
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public AsyncMessageSenderImpl(int repeatFactor) {
        this.repeatFactor = repeatFactor;
    }

//    public static void main(String[] args) {
//        AsyncMessageSender sender = new AsyncMessageSenderImpl(3);
//
//        Message[] messages = {
//
//                new Message("John", "Mary", "Hello!"),
//                new Message("Clara", "Bruce", "How are you today?")
//        };
//
//        sender.sendMessages(messages);
//        sender.stop();
//
//        System.out.println("Completed.");
//    }

    @Override
    public void sendMessages(Message[] messages) {
        for (Message msg : messages) {
            for (int i = 0; i < repeatFactor; i++) {
                executor.submit(() -> {
                    System.out.printf("(%s>%s): %s\n", msg.from, msg.to, msg.text);
                });
            }
        }
    }

    @Override
    public void stop() {
        executor.shutdown();
    }
}
