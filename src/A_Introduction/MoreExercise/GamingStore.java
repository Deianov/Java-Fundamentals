package A_Introduction.MoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double spent = 0;
        double price;
        String input = scanner.nextLine();
        while (!input.equals("Game Time")) {
            switch (input) {
                case "OutFall 4" : price = 39.99; break;
                case "CS: OG" : price = 15.99; break;
                case "Zplinter Zell" : price = 19.99; break;
                case "Honored 2" : price = 59.99; break;
                case "RoverWatch" : price = 29.99; break;
                case "RoverWatch Origins Edition" : price = 39.99; break;
                default: price = 0; break;
            }
            if (price > 0) {
                if (price <= budget - spent) {
                    spent = spent + price;
                    System.out.println("Bought " + input);
                } else {
                    System.out.println("Too Expensive");
                }
            } else {
                System.out.println("Not Found");
            }
            if (budget - spent == 0) {
                System.out.println("Out of money!");
                return;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, budget - spent);
    }
}
