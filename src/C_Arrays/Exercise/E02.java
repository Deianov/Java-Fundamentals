// 02. Common Elements

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrOne = scanner.nextLine().split(" ");
        String[] arrTwo = scanner.nextLine().split(" ");
        for (String s: arrTwo) {
            if (Arrays.stream(arrOne).anyMatch(s::equals)) {
                System.out.print(s + " ");
            }
        }
    }
}
