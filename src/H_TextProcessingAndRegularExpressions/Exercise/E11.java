//11. SoftUni Bar Income

package H_TextProcessingAndRegularExpressions.Exercise;

        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        double totalIncome = 0;

        String regex = "[^A-Za-z\\|\\%\\$\\.]*%[^A-Za-z\\|\\%\\$\\.]*(?<name>[A-Z][a-z]+)[^A-Za-z\\|\\%\\$\\.]*%[^\\|\\%\\$\\.]*<[^A-Za-z\\|\\%\\$\\.]*(?<product>[\\w-]+)[^A-Za-z\\|\\%\\$\\.]*>[^\\|\\%\\$\\.]*\\|[^0-9\\|\\%\\$\\.]*(?<count>\\d+)[^0-9\\|\\%\\$\\.]*\\|[^0-9\\|\\%\\$\\.]*(?<price>\\d+\\.?[\\d+]*)[^0-9\\|\\%\\$\\.]*\\$";
        Pattern pattern = Pattern.compile(regex);

        while (!"end of shift".equalsIgnoreCase(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {

                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double total = count * price;

                System.out.println(String.format("%s: %s - %.2f", name, product, total));
                totalIncome = totalIncome + total;
            }

        }
        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
