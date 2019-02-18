// 05. Even and Odd Subtraction

package C_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(items).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sumOdd = 0;
        int sumEven = 0;
        for (int num : arr) {
            if (num % 2 == 0) sumEven += num;
            else  sumOdd += num;
        }
        System.out.println(sumEven - sumOdd);
    }
}
