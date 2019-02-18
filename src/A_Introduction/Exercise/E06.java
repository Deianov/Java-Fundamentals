// 01.Java-Introduction-Exercise
// 06.Strong Number

package A_Introduction.Exercise;

import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int fact;
        int digit;
        for (int n = num; n > 0 ; n = n / 10) {
            fact = 0;
            digit = n % 10 == 0 ? 1 : n % 10;
            for (int j = 1; j <= digit ; j++) {
                fact = fact == 0 ? j : fact * j;
            }
            sum += fact;
        }
        System.out.println(num == 0 ? "no" : num == sum ? "yes" : "no");
    }
}
