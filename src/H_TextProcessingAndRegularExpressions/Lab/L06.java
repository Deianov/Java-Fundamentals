//06. Match Full Name

package H_TextProcessingAndRegularExpressions.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
