// 1.Day of Week

package C_Arrays.Lab;

import java.util.Scanner;

public class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] weekDays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println((day > 0 && day < 8) ? weekDays[day - 1] : "Invalid day!");
    }
}
