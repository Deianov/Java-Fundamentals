package B_DataTypes.Exercises;

import java.util.Scanner;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int spicePerDay = Integer.parseInt(scanner.nextLine());
        int spice = 0;
        int days = 0;
        while (spicePerDay >= 100) {
            spice += spicePerDay - 26;
            spicePerDay -= 10;
            days++;
        }
        if (spice >= 26) spice -= 26;
        System.out.println(days);
        System.out.println(spice);
    }
}
