// 07. Condense Array to Number

package C_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int length = arr.length;

        if (length == 1) {
            System.out.println(arr[0]);
            return;
        }

        while (length-- > 2) {
            for (int i = 0; i < length; i++) {
                arr[i] = arr[i] + arr[i + 1];
            }
        }
        System.out.println(arr[0] + arr[1]);
    }
}
