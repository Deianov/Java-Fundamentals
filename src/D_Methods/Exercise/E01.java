package D_Methods.Exercise;

import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        System.out.println(getSmallest(a,b,c));
    }
    private static int getSmallest(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
