package D_Methods.Exercise;

import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number ; i++) {
            printLine(number);
            System.out.println();
        }
    }
    private static void printLine(int number) {
        for (int i = 0; i < number ; i++) {
            System.out.print(number + " ");
        }
    }
}
