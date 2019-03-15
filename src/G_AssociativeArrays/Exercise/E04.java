//04. Orders

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, Double[]> products = new LinkedHashMap<>();

        while (!"buy".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String name = data[0];
            double price = Double.parseDouble(data[1]);
            double quantity = Double.parseDouble(data[2]);

            products.putIfAbsent(name, new Double[] {0.0, 0.0});
            products.get(name)[0] = price;
            products.get(name)[1] = products.get(name)[1] + quantity;
        }

        products.entrySet().forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()[0] * e.getValue()[1]));
    }
}
