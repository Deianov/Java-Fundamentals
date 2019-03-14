// 07. Remove Negatives and Reverse

package E_ArrayList.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class L07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .filter(n -> n > 0)
                .collect(Collectors.toList());

        if (numbers.size() == 0) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
            printList(numbers);
        }
    }
    static void printList(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
