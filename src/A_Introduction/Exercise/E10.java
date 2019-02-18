// 01.Java-Introduction-Exercise
// 10. Rage Expenses

package A_Introduction.Exercise;

import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gamesLost = Integer.parseInt(scanner.nextLine());
        float headsetPrice = Float.parseFloat(scanner.nextLine());
        float mousePrice = Float.parseFloat(scanner.nextLine());
        float keyboardPrice = Float.parseFloat(scanner.nextLine());
        float displayPrice = Float.parseFloat(scanner.nextLine());
        float expenses = 0;
        int keyboards = 0;
        boolean isSecond, isThird;
        for (int i = 1; i <= gamesLost; i++) {
            isSecond = i % 2 == 0;
            isThird = i % 3 == 0;
            if (isSecond) expenses = expenses + headsetPrice;
            if (isThird) expenses = expenses + mousePrice;
            if (isSecond && isThird) {
                expenses = expenses + keyboardPrice;
                if (++keyboards % 2 == 0) expenses = expenses + displayPrice;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
