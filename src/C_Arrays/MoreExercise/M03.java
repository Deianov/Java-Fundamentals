// 03. Recursive Fibonacci

package C_Arrays.MoreExercise;

import java.util.Scanner;

public class M03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(fibonacci(number));
    }
    private static int fibonacci(int n)  {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
