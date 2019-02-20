// 05. List Manipulation Advanced

package E_Lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbers = Arrays
                .stream(input.split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!"end".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] line = input.split("\\s");
            String command = line[0];
            String option = line[1];
            switch (command) {
                case "Contains":
                    System.out.println(containsListValue(numbers, Integer.parseInt(option))
                            ? "Yes" : "No such number");
                    break;
                case "Print":
                    switch (option) {
                        case "even":
                            printFromListEvensOdds(numbers, true);
                            break;
                        case "odd":
                            printFromListEvensOdds(numbers, false);
                            break;
                    }
                    break;
                case "Get":
                    if (option.equals("sum")) {
                        System.out.println(getListSum(numbers));
                    }
                    break;
                case "Filter":
                    printListByFilter(numbers, option, Integer.parseInt(line[2]));
                    break;
            }
        }
    }
    private static boolean containsListValue(List<Integer> list, int value) {
        return list.contains(value);
    }
    private static void printFromListEvensOdds(List<Integer> list, boolean isEven) {
        List<Integer> result = new ArrayList<>();
        for (int value : list) {
            if (isEven && value != 0 && value % 2 == 0 ) {
                result.add(value);
            } else if (!isEven && value % 2 != 0) {
                result.add(value);
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
    private static int getListSum(List<Integer> list) {
        int sum = 0;
        for (int value: list) {
            sum += value;
        }
        return sum;
    }
    private static void printListByFilter(List<Integer> list, String filter, int value) {
        List<Integer> temp = new ArrayList<>();

        for (int num : list) {
            boolean flag = false;

            switch (filter) {
                case "<" : flag = num < value; break;
                case ">" : flag = num > value; break;
                case ">=": flag = num >= value; break;
                case "<=": flag = num <= value; break;
            }

            if (flag) temp.add(num);
        }
        System.out.println(temp.toString().replaceAll("[\\[\\],]", ""));
    }
}
