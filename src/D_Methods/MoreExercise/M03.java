// 3.Longer Line

package D_Methods.MoreExercise;

import java.util.Scanner;

public class M03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coords = new int[8];
        for (int i = 0; i < 8; i++) {
            coords[i] = Integer.parseInt(scanner.nextLine());
        }
        if (distance(coords[0], coords[1], coords[2], coords[3]) >= distance(coords[4], coords[5], coords[6], coords[7])) {
            if (distance(0,0, coords[0], coords[1]) <= distance(0, 0, coords[2], coords[3])) {
                System.out.println(point(coords[0], coords[1]) + point(coords[2], coords[3]));
            } else {
                System.out.println(point(coords[2], coords[3]) + point(coords[0], coords[1]));
            }
        } else {
            if (distance(0,0, coords[4], coords[5]) <= distance(0, 0, coords[6], coords[7])) {
                System.out.println(point(coords[4], coords[5]) + point(coords[6], coords[7]));
            } else {
                System.out.println(point(coords[6], coords[7]) + point(coords[4], coords[5]));
            }
        }
    }
    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }
    private static String point(int x, int y) {
        return "(" + x + ", " + y + ")";
    }
}
