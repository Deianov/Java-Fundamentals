// 02. Print Numbers in Reverse Order

package C_Arrays.Lab;

import java.util.Scanner;

public class L02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
