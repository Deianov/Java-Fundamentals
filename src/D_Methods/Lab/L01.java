// 1.	Sign of Integer

package D_Methods.Lab;

import java.util.Scanner;

public class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        printSign(num);
    }
    public static void printSign(int number) {
        if (number > 0) System.out.printf("The number %d is positive.",number);
        else if (number < 0) System.out.printf("The number %d is negative.", number);
        else System.out.println("The number 0 is zero.");
    }
}
