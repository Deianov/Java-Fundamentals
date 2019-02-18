// 05. Orders

package D_Methods.Lab;

import java.util.Scanner;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine().toLowerCase();
        double quantity = Double.parseDouble(scanner.nextLine());
        printPrice(product, quantity);
    }
    public static void printPrice(String product, double quantity) {
        String[] products = {"coffee", "water", "coke", "snacks"};
        double[] prices = {1.5, 1.0, 1.4, 2.0};
        for (int i = 0; i < product.length() ; i++) {
            if (products[i].equals(product)) {
                System.out.printf("%.2f", prices[i] * quantity);
                break;
            }
        }
    }
}
