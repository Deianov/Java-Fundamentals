// 1. Train

package C_Arrays.Exercise;

import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[wagons];
        for (int i = 0; i < wagons; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        int people = 0;
        for (int p : arr) {
            System.out.print(p + " ");
            people += p;
        }
        System.out.print("\n" + people);
    }
}
