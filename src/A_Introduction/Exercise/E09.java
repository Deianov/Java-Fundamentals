// 01.Java-Introduction-Exercise
// 09. Padawan Equipment

package A_Introduction.Exercise;

import java.util.Scanner;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountMoney = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceLightsabers = Double.parseDouble(scanner.nextLine());
        double priceRobes  = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double neededMoney = priceLightsabers * Math.ceil(countStudents * 1.1);
        neededMoney = neededMoney + (priceRobes * countStudents);
        neededMoney = neededMoney + (priceBelts * (countStudents - (countStudents / 6)));

        if (neededMoney <= amountMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", neededMoney);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", neededMoney - amountMoney);
        }
    }
}
