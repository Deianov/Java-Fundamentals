// 06. Equal Sums

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i ; j++) {
                sumLeft += arr[j];
            }
            for (int j = i + 1; j < length ; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}
