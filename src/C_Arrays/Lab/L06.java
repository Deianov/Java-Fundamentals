// 06. Equal Arrays

package C_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items1 = scanner.nextLine().split(" ");
        String[] items2 = scanner.nextLine().split( " ");
        int[] arr1 = Arrays.stream(items1).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] arr2 = Arrays.stream(items2).mapToInt(e -> Integer.parseInt(e)).toArray();
        int arrSum = 0;
        for (int i = 0; i < arr1.length ; i++) {
            arrSum += arr1[i];
            if (arr1[i] != arr2[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }
        }
        System.out.printf("Arrays are identical. Sum: %d", arrSum);
    }
}
