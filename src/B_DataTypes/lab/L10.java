// 10.Special Numbers

package B_DataTypes.lab;

import java.util.Arrays;
import java.util.Scanner;

public class L10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;
        while (count++ < number) {
            System.out.println(count + " -> " + (Arrays.asList(5, 7, 11).contains((count+"").chars().map(c->c-48).sum()) ? "True" : "False"));
        }
    }
}
