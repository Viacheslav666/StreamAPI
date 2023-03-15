import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

        public static void main(String[] args) {
        System.out.println("Task №1.1");
        Stream<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)).stream();
        findMinMax(
                integerList,
                Integer::compareTo,
                (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
        );
        integerList.close();
            System.out.println("Task №2");

        List<Number> numbers = new ArrayList<>(Arrays.asList(1,2,3,6,59,4,10));

            searchForEvenNumbers(numbers);

    }
    public static void  searchForEvenNumbers(List<Number> number) {
        Stream<Number> stream;
        number.stream()
                .filter(t -> (t.intValue() % 2) == 0)
                .forEach(System.out::println);

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }




}
