// 07. Append Arrays

package E_Lists.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> output = Arrays.stream(input.split("[|]")).collect(Collectors.toList());
        Collections.reverse(output);

        input = String.join(" ", output);
        output = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        printList(output);
    }

    private static void printList(List<String> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
