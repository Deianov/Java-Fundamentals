// 05. Top Integers

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean isBigger = true;
            for (int j = i + 1; j < length ; j++) {
                if (arr[i] <= arr[j]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) System.out.print(arr[i] + " ");
        }
    }
}
