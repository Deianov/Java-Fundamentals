// 3.Printing Triangle

package D_Methods.Lab;

import java.util.Scanner;

public class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int endIndex = 0;
        for (int i = 0; i < (2 * num) - 1 ; i++) {
            endIndex += i < num ? 1 : -1;
            printLine(1, endIndex);
        }
    }
    public static void printLine(int start, int end) {
        System.out.println();
        for (int i = start; i <= end ; i++) {
            System.out.print(i + " ");
        }
    }
}
