package tasks.task03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Temperature {

    public static void main(String[] args) {
        getOutput(handleData(getData()));
    }

    private static Map<String, Integer> getData() {
        Map<String, Integer> temperature = new HashMap<>();
        temperature.put("Monday", 8);
        temperature.put("Tuesday", 9);
        temperature.put("Wednesday", 13);
        temperature.put("Thursday", 11);
        temperature.put("Friday", 10);
        temperature.put("Saturday", 15);
        temperature.put("Sunday", 12);
        return temperature;
    }

    private static Map<String, Integer> handleData(Map<String, Integer> temperature) {
        return temperature.entrySet().stream()
                .filter(str -> str.getValue() >= 10 && str.getValue() <=13)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    private static void getOutput(Map<String, Integer> temperature) {
        AtomicInteger count = new AtomicInteger(1);
        temperature.forEach((dayWeek, value) -> System.out.println(count.getAndIncrement()
                + ") " + dayWeek + " +" + value + "°C"));
    }
}
