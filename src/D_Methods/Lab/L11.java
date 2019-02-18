// 11. Math operations

package D_Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class L11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println(new DecimalFormat("0.##").format(calculate(a, operator, b)));
    }
    private static double calculate(int a, String operator, int b) {
        double result = 0.0;
        switch (operator) {
            case "+" : result = a + b;break;
            case "-" : result = a - b;break;
            case "/" : result = b != 0 ? a / (double)b : 0;break;
            case "*" : result = a * b;break;
        }
        return result;
    }
}
