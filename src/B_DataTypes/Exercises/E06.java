// 6.Triples of Latin Letters

package B_DataTypes.Exercises;

import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < n ; k++) {
                    System.out.printf("%s%s%s%n", (char)(97 + i), (char)(97 + j), (char)(97 + k));
                }
            }
        }
    }
}
