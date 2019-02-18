// 3. Floating Equality

package B_DataTypes.MoreExercise;

import java.util.Scanner;

public class M03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println((Math.abs(a - b) >= 0.000001 ? "False" : "True"));
    }
}
