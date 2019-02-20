// 04. List Manipulation Basics - 80%

package E_Lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class L04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Integer> numbers = Arrays
                .stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!"end".equals(line = scanner.nextLine())) {
            String[] command = line.split("\\s+");
            int num = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "Add":
                    numbers.add(num);
                    break;
                case "Remove":
                    numbers.remove(num);
                    break;
                case "RemoveAt":
                    numbers.remove(num);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    numbers.add(index,num);
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
