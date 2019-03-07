//01. Messaging

package E_Lists.MoreExercise;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<String> chars = scanner.nextLine().chars().mapToObj((i) -> Character.toString((char)i)).collect(Collectors.toList());

        for (int number: numbers) {
            int sum = 0;
            while (number % 10 > 0) {
                sum += number % 10;
                number = number / 10;
            }
            int index = getElementIndex(chars, sum);
            System.out.print(chars.get(index));
            chars.remove(index);
        }
    }

    private static int getElementIndex (List<String> stringList, int index) {
        return index >= stringList.size() ? index % stringList.size() : index;
    }
}
