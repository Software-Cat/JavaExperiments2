import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                even.add(number);
            } else {
                odd.add(number);
            }
        }

        odd.sort(Comparator.naturalOrder());
        even.sort(Comparator.reverseOrder());

        return Stream.concat(odd.stream(), even.stream())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 4, 7, 2, 1, 4));

        System.out.println(sortOddEven(list));
    }
}
