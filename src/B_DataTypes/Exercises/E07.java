package B_DataTypes.Exercises;

import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int waterTank = 255;
        int water;
        while (n-- > 0) {
            water = Integer.parseInt(scanner.nextLine());
            if (water > waterTank) {
                System.out.println("Insufficient capacity!");
            } else {
                waterTank -= water;
            }
        }
        System.out.println(255 - waterTank);
    }
}
