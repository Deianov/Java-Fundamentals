package B_DataTypes.lab;

import java.util.Scanner;

public class L08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);
        System.out.println( a > 95 ? "lower-case" : "upper-case");
    }
}
