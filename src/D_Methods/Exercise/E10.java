package D_Methods.Exercise;

import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number ; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }

    }
    private static boolean isTopNumber(int number) {
        boolean hasOddDigit = false;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
            hasOddDigit = (hasOddDigit) || (digit % 2 != 0);
        }
        return hasOddDigit && (sum % 8 == 0);
    }
}
