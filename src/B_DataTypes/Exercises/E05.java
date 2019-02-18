package B_DataTypes.Exercises;

import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short start = Short.parseShort(scanner.nextLine());
        short end = Short.parseShort(scanner.nextLine());
        for (short d = start; d <= end; d++) {
            System.out.print((char)d + " ");
        }
    }
}
