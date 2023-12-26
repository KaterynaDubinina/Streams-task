package tasks.task02;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Products {

    public static void main(String[] args) {
        getOutput(handleData(getData()));
    }

    private static Map<String, Double> getData() {
        Map<String, Double> products = new HashMap<>();
        products.put("Onion", 1.05);
        products.put("Potato", 1.50);
        products.put("Beet", 1.75);
        products.put("Carrot", 2.00);
        products.put("Cabbage", 2.75);
        products.put("Tomato", 3.15);
        return products;
    }

    private static Map<String, Double> handleData(Map<String, Double> products) {
        return products.entrySet().stream()
                .filter(str -> str.getValue() <= 2.00)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    private static void getOutput(Map<String, Double> products) {
        AtomicInteger count = new AtomicInteger(1);
        products.forEach((productName, price) -> System.out.println(count.getAndIncrement()
                + ") " + productName + " EUR " + price));
    }
}
