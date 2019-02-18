// 4. Tribonacci Sequence

package D_Methods.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        System.out.println(Arrays.stream(tribonacci(input)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
    private static int[] tribonacci(int length) {
        int[] array = new int[length];
        if (length > 0) array[0] = 1;
        if (length > 1) array[1] = 1;
        if (length > 2) array[2] = 2;
        if (length > 3) {
            for (int i = 3; i < length ; i++) {
                array[i] = array[i-1] + array[i-2] + array[i-3];
            }
        }
        return array;
    }
}
