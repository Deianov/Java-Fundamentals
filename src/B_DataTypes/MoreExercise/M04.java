// 4. Refactoring: Prime Checker

package B_DataTypes.MoreExercise;

import java.util.Scanner;

public class M04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTo = Integer.parseInt(scanner.nextLine());
        for (int numTest = 2; numTest <= numTo ; numTest++) {
            boolean isPrime = true;
            for (int i = 2; i * i <= numTest ; i++) {
                if (numTest % i == 0) {
                    isPrime = false;
                }
            }
            System.out.printf("%d -> %b%n", numTest, isPrime);
        }
    }
}
