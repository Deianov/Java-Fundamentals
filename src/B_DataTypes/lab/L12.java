// 12.Refactor Special Numbers

package B_DataTypes.lab;

import java.util.Scanner;

public class L12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberTo = Integer.parseInt(scanner.nextLine());
        boolean isSpecial;
        for (int i = 1; i <= numberTo ; i++) {
            int digits = i;
            int digitsSum = 0;
            while (digits > 0) {
                digitsSum += digits % 10;
                digits = digits / 10;
            }
            isSpecial = (digitsSum == 5) || (digitsSum == 7) || (digitsSum == 11);
            System.out.printf("%d -> %s%n", i, (isSpecial) ? "True" : "False");
        }
    }
}
