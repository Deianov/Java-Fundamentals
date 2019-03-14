// 1.Sum Adjacent Equal Numbers

package E_ArrayList.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> values = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < values.size() ; i++) {
            numbers.add(Double.parseDouble(values.get(i)));
        }
        while (true) {
           boolean flag = false;
            for (int i = 0; i < numbers.size() - 1 ; i++) {
                if (numbers.get(i).equals(numbers.get(i + 1))) {
                    numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                    numbers.remove(i + 1);
                    i = -1;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);
    }

    static String joinElementsByDelimiter(List<Double> items, String delimiter) {
        String output = "";
        for (Double item: items ) {
            output += (new DecimalFormat("0.#").format(item)) + delimiter;
        }
        return output;
    }
}
