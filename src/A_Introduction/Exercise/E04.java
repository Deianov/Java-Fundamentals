// 01.Java-Introduction-Exercise
// 04.Print and Sum

package A_Introduction.Exercise;

import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = startNum; i <= endNum ; i++) {
            System.out.print(i == startNum ? i : " " + i);
            sum += i;
        }
        System.out.println("\nSum: " + sum);
    }
}