//Technology Fundamentals Mid Exam - 16 April 2019 - group 1
//Problem 1 - Easter Cozonacs
package Z_Exams.mid_exam;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double priceFloor = Double.parseDouble(scanner.nextLine());
        double priceEggs = priceFloor * 0.75;
        double priceMilk = priceFloor * 1.25 * 0.25;
        double priceCozonacs = priceEggs + priceFloor + priceMilk;

        int coloredEggs = 0;
        int cozonacs = 0;

        while (budget > priceCozonacs) {
            cozonacs++;
            coloredEggs += 3;
            budget = budget - priceCozonacs;

            if (cozonacs % 3 == 0) {
                coloredEggs -= cozonacs - 2;
            }
        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",cozonacs,coloredEggs,budget);
    }
}
