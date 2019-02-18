package D_Methods.Exercise;

import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        System.out.println(subtract(sum(a, b), c));
    }
    private static int sum(int a, int b) {
        return a + b;
    }
    private static int subtract(int a, int b) {
        return a - b;
    }
}
