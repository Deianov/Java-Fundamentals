package B_DataTypes.Exercises;

import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        System.out.println(sum);
    }
}
