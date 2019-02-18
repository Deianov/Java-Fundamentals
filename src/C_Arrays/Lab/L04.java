// 04. Reverse Array of Strings

package C_Arrays.Lab;

import java.util.Scanner;

public class L04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        for (int i = 0; i < arr.length / 2 ; i++) {
            String old = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = old;
        }
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
