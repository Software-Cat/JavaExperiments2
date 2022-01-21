import java.util.Scanner;

enum DaysOfTheWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaysOfTheWeek day = DaysOfTheWeek.valueOf(scanner.next());
        int numLetters = switch (day) {
            case TUESDAY -> 7;
            case WEDNESDAY -> 9;
            case THURSDAY, SATURDAY -> 8;
            case MONDAY, FRIDAY, SUNDAY -> 6;
        };

        // Put switch expression here
        System.out.println(numLetters);
    }
}
