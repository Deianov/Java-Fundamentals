package D_Methods.MoreExercise;

import java.util.Scanner;

public class M02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        if (distance(0,0, x2, y2) < distance(0,0, x1, y1)) {
            System.out.println(point(x2, y2));
        } else {
            System.out.println(point(x1, y1));
        }
    }
    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }
    private static String point(int x, int y) {
        return "(" + x + ", " + y + ")";
    }
}
