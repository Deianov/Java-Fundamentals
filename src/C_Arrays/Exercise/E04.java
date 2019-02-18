// 4. Array Rotation

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = input.length;
        int rotate = Integer.parseInt(scanner.nextLine());
        int[] arrTemp = new int[length];
        while (rotate-- > 0) {
            for (int i = 0; i < length - 1; i++) {
                arrTemp[i] = input[i + 1];
            }
            arrTemp[length - 1] = input[0];
            for (int i = 0; i < length ; i++) {
                input[i] = arrTemp[i];
            }
        }
        System.out.println(Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
