package D_Methods.MoreExercise;

import java.util.Scanner;

public class M01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toLowerCase()) {
            case "int":
                printResult(Integer.parseInt(scanner.nextLine()));
                break;
            case "real":
                printResult(Double.parseDouble(scanner.nextLine()));
                break;
            case "string":
                printResult(scanner.nextLine());
        }
    }
    private static void printResult(int input) {
        System.out.println(input * 2);
    }
    private static void printResult(double input) {
        System.out.printf("%.2f", input * 1.5);
    }
    private static void printResult(String input) {
        System.out.println("$" + input + "$");
    }
}
