package B_DataTypes.Exercises;

import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        String input;
        int sum = 0;
        int digit;
        for (int n = 0; n < lines; n++) {
            input = scanner.nextLine();
            for (int d = 0; d < input.length(); d++) {
                sum += input.charAt(d);
            }
        }
        System.out.println("The sum equals: " + sum);
    }
}
