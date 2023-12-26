package tasks.task01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Names {

    public static void main(String[] args) {
        getOutput(handleData(getData()));
    }

    private static Stream<String> getData() {
        return Stream.of("Alice", "Kate",
                "Angelina", "Tiffany", "Bradley", "William");
    }

    private static Stream<String> handleData(Stream<String> names) {
        return names.filter(str -> str.startsWith("K"));
    }

    private static void getOutput(Stream<String> str) {
        AtomicInteger count = new AtomicInteger(1);
        str.forEach(names -> System.out.println(count.getAndIncrement() + ") " + names));
    }
}
