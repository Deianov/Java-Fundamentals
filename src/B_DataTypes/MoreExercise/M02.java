// 2. From Left to The Right

package B_DataTypes.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class M02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            long[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long numGreater = Math.abs(numbers[(numbers[0] > numbers[1] ? 0 : 1)]);
            System.out.println(("" + numGreater).chars().map(c -> c - 48).sum());
        }
    }
}