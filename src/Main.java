import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("12","242","3231","432","52","641");
        Comparator<String> stringComparator = Comparator.comparing(String::length);
        BiConsumer<String, String> biConsumer = (x, y) -> System.out.println("Min " + x + " Max " + y);

        findMinMax(stringStream, stringComparator, biConsumer);

        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9,10,12);
        findEvenNumbers(integerList);

    }
    public static <T> void findMinMax(
            Stream <? extends T> stream,
            Comparator <? super T> order,
            BiConsumer <? super T, ? super T> minMaxConsumer
            ) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        System.out.println("Task 1");
        minMaxConsumer.accept(list.size() == 0 ? null : list.get(0), list.size() == 0 ? null : list.get(list.size() - 1));
    }
    public static void findEvenNumbers(List<Integer> list) {
        System.out.println("Task 2");
        int evenNumbers = (int)(list.stream()
                .filter((n) -> (n % 2) == 0)).count();
        System.out.println("Amount of even numbers " + evenNumbers);
    }
}