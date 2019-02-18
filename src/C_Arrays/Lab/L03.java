// 3.Sum Even Numbers

package C_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(items).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sumEven = 0;
        for (int num : arr ) {
            if (num % 2 == 0) sumEven += num;
        }
        System.out.println(sumEven);
    }
}
