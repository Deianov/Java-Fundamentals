package D_Methods.Lab;

import java.util.Scanner;

public class L06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%.0f",rectangleArea(
                Double.parseDouble(scanner.nextLine()),
                Double.parseDouble(scanner.nextLine())));
    }
    private static double rectangleArea(double width, double height) {
        return width * height;
    }
}
