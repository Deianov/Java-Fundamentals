package B_DataTypes.lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal number = new BigDecimal(0);
        while (n-- > 0) {
            number = number.add( new BigDecimal(scanner.nextLine()));
        }
        System.out.println(number);
    }
}
