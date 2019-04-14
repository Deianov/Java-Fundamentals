//Technology Fundamentals Mid Exam - 10 March 2019 Group 1
//01. Spring Vacation Trip
package Z_Exams.mid_exam_20190310;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tripDays = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int groupCount = Integer.parseInt(scanner.nextLine());
        double priceFuelKM = Double.parseDouble(scanner.nextLine());
        double priceFoodPerDayPerson = Double.parseDouble(scanner.nextLine());
        double priceRoomPerDayPerson = Double.parseDouble(scanner.nextLine());

        if (tripDays == 0 || groupCount == 0) return;

        double expensesHotel = (groupCount * priceRoomPerDayPerson * tripDays * (groupCount > 10 ? 0.75 : 1));
        double expensesFood = groupCount * priceFoodPerDayPerson * tripDays;

        double currentExpenses = expensesFood + expensesHotel;

        for (int day = 1; day <= tripDays; day++) {
            double travelledDistance = Double.parseDouble(scanner.nextLine());

            currentExpenses = currentExpenses + (travelledDistance * priceFuelKM);

            if (day % 3 == 0 || day % 5 == 0) {
                currentExpenses = currentExpenses * 1.4;
            }
            if (day % 7 == 0) {
                currentExpenses = currentExpenses - (currentExpenses / groupCount);
            }
        }

        if (currentExpenses > budget) {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentExpenses - budget);
        } else {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - currentExpenses);
        }
    }
}
