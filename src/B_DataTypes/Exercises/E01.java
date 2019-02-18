package B_DataTypes.Exercises;

import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        int number4 = Integer.parseInt(scanner.nextLine());
        System.out.println((number1 + number2) / number3 * number4);
    }
}
