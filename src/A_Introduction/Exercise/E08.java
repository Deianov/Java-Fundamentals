// 01.Java-Introduction-Exercise
// 08. Triangle of Numbers

package A_Introduction.Exercise;

import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < i ; j++) {
                if (j == 0) {
                    System.out.print("\n" + i);
                } else {
                    System.out.print(" " + i);
                }
            }
        }
    }
}
