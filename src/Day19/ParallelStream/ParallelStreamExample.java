package Day19.ParallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, n -> n <= 100, n -> n + 1).toList();

        list.stream().filter(num -> num > 50)
                .parallel()
                .map(num -> num * num)
                .limit(10)
                .forEach(System.out::println);
    }
}
