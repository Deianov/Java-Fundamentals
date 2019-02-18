// 06. Balanced Brackets

package B_DataTypes.MoreExercise;

import java.util.Scanner;

public class M06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int count = 0;
        while (lines-- > 0) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("(")) {
                count++;
            } else if (input.equalsIgnoreCase(")")) {
                count--;
            }
            if (count < 0 || count > 1) break;
        }
        System.out.println((count == 0) ? "BALANCED" : "UNBALANCED");
    }
}
