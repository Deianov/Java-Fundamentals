// 01.Java-Introduction-Exercise
// 02.Division

package A_Introduction.Exercise;

import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int numbers [] = {10, 7, 6, 3, 2};
        for (int i : numbers) {
            if (num % i == 0) {
                System.out.println("The number is divisible by " + i);
                return;
            }
        }
        System.out.println("Not divisible");
    }
}
