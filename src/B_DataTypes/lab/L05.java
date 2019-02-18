package B_DataTypes.lab;

import java.util.Scanner;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fName = scanner.nextLine();
        String lName = scanner.nextLine();
        String deli = scanner.nextLine();
        System.out.printf("%s%s%s", fName, deli, lName);
    }
}
