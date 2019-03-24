// 08. Extract Emails

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E08 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        Pattern pattern = Pattern.compile("(?<email>(?<=^|\\s|,)[A-Za-z0-9][\\w\\.\\-]*[A-Za-z0-9]@[A-Za-z][A-Za-z\\-\\.]*[\\.][A-Za-z]{2,63}(?=\\s|,|.$|$))");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group("email"));
        }
    }
}
