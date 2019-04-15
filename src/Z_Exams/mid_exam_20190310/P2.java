//Technology Fundamentals Mid Exam - 10 March 2019 Group 1
//02. Hello, France
package Z_Exams.mid_exam_20190310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|+");
        double budget = Double.parseDouble(scanner.nextLine());

        List<String> itemTypes = Arrays.asList("Clothes", "Shoes", "Accessories");
        List<Double> itemMaxPrices = Arrays.asList(50.0, 35.0, 20.5);

        double prifit = 0;
        List<Double> prices = new ArrayList<>();

        for (String item : input) {
            String[] data = item.split("->");
            String type = data[0];
            double price = Double.parseDouble(data[1]);
            int index = itemTypes.indexOf(type);
            if (price <= itemMaxPrices.get(index) && price <= budget) {
                budget = budget - price;
                prifit = prifit + (price * 0.4);
                prices.add(price * 1.4);
            }
        }
        for (double p : prices) {
            System.out.printf("%.2f ", p);
        }
        budget = budget + prices.stream().mapToDouble(Double::doubleValue).sum();
        System.out.printf("%nProfit: %.2f", prifit);
        System.out.printf(budget >= 150 ? "%nHello, France!" : "%nTime to go.");
    }
}
