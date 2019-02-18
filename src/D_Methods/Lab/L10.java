package D_Methods.Lab;

import java.util.Scanner;

public class L10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(multipleEvensAndOdds(Math.abs(Integer.parseInt(scanner.nextLine()))));
    }
    private static int multipleEvensAndOdds(int number) {
        return sumOfEvenDigits(number) * sumOfOddDigits(number);
    }
    private static int sumOfEvenDigits (int number) {
        int result = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) result += digit;
            number = number / 10;
        }
        return result;
    }
    private static int sumOfOddDigits (int number) {
        int result = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) result += digit;
            number = number / 10;
        }
        return result;
    }
}
