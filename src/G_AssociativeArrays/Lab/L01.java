//01. Count Real Numbers

package G_AssociativeArrays.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (double num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }
            counts.put(num, counts.get(num) + 1);
        }

        DecimalFormat decimal = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> map : counts.entrySet()) {
            System.out.printf("%s -> %d%n", decimal.format(map.getKey()), map.getValue());
        }

    }
}
