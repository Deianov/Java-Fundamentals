//05. Bomb Numbers

package E_ArrayList.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bombLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombElement = bombLine[0];
        int bombPower = bombLine[1];
        // bomb/power position
        int[] bombs = findBombs(numbers, bombElement, bombPower);
        // detonation
        for (int i = 0; i < bombs.length ; i++) {
            if (bombs[i] > -1) {
                int power = bombs[i];
                int startIndex = i - power < 0 ? 0 : i - power;
                int endIndex = i + power < bombs.length ? i + power : bombs.length - 1;
                for (int j = startIndex; j <= endIndex ; j++) {
                    bombs[j] = -2;
                }
            }
        }

        int sumRemaining = 0;
        for (int i = 0; i < bombs.length ; i++) {
            if (bombs[i] == -1) {
                sumRemaining += numbers.get(i);
            }
        }

        System.out.println(sumRemaining);
    }

    private static int[] findBombs(List<Integer> numbers, int element, int power) {
        int[] bombs = new int[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            bombs[i] = numbers.get(i) == element ? Math.abs(power) : -1;
        }
        return bombs;
    }
}
