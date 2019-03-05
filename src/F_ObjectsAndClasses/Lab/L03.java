//03. Big Factorial

package F_ObjectsAndClasses.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(factorial(n));
    }

    private static BigInteger factorial(int fact) {
        BigInteger f = new BigInteger(String.valueOf(1));

        for (int i = 2; i <= fact ; i++) {
           f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
