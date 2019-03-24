//09. Furniture

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double moneySpend = 0;

        Pattern pattern = Pattern.compile("\\n*>>([^<]+)<<(\\d+\\.?[\\d]*)!(\\d+)\\n*");
        System.out.println("Bought furniture:");

        while (!"Purchase".equalsIgnoreCase(input)) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.println(matcher.group(1));
                moneySpend += Double.parseDouble(matcher.group(2)) * Double.parseDouble(matcher.group(3));
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f", moneySpend);
    }
}
