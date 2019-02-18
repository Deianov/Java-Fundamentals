package A_Introduction.MoreExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        System.out.println(Integer.max(num3, Integer.max(num1, num2)));
        if (num1 >= num2 && num1 >= num3) {
            System.out.println(Integer.max(num2, num3));
        } else if (num2 >= num1 && num2 >= num3) {
            System.out.println(Integer.max(num1, num3));
        } else {
            System.out.println(Integer.max(num1, num2));
        }
        System.out.println(Integer.min(num3, Integer.min(num1, num2)));
    }
}
