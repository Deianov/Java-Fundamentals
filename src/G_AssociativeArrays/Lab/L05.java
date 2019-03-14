// 05. Largest 3 Numbers

package G_AssociativeArrays.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());
        list = list.subList(0, Math.min(3, list.size()));
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
