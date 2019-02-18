package D_Methods.Exercise;

import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", factorial(a) / (double)factorial(b));
    }
    private static long factorial(int number) {
        long result = 1;
        for (int i = 2; i <= number ; i++) {
            result *= i;
        }
        return result;
    }
}
