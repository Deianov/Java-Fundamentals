// 08. Magic Sum

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scanner.nextLine());
        int[] unique = new int[arr.length];
        int uniqueIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length ; j++) {
                int a = arr[i];
                int b = arr[j];
                if (i != j && a + b == sum) {
                    if (uniqueIndex == 0 || !IntStream.of(unique).anyMatch(x -> x == a)) {
                        System.out.println(a + " " + b);
                        unique[uniqueIndex] = a;
                        unique[uniqueIndex + 1] = b;
                        uniqueIndex += 2;
                    }
                }
            }
        }
    }
}
