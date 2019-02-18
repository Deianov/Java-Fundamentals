// 01.Java-Introduction-Exercise
// 07.Vending Machine

package A_Introduction.Exercise;

import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double money = 0;
        double coin;
        while (!input.equals("Start")) {
            coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                money = money + coin;
            } else {
                System.out.println("Cannot accept " + String.format("%.2f", coin));
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        double price;
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts" : price = 2.0; break;
                case "Water" : price = 0.7; break;
                case "Crisps" : price = 1.5; break;
                case "Soda" : price = 0.8; break;
                case "Coke" : price = 1.0; break;
                default: price = 0;
            }
            if (price == 0) {
                System.out.println("Invalid product");
            } else if (price > money) {
                System.out.println("Sorry, not enough money");
            } else {
                System.out.println("Purchased " + input);
                money = money - price;
            }
            input = scanner.nextLine();
        }
        System.out.println("Change: " + String.format("%.2f", money));
    }
}
