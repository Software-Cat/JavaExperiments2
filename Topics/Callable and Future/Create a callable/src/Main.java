import java.util.Scanner;
import java.util.concurrent.Callable;

class CallableUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static Callable<String> getCallable() {
        return scanner::next;
    }
}
