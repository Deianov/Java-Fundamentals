//14.Letters Change Numbers
package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E14 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String regex = "(([a-zA-Z])(\\d+)([a-zA-Z]))";
        double sum = 0.0;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int charStart = matcher.group(2).charAt(0);
            double number = Double.parseDouble(matcher.group(3));
            int charEnd = matcher.group(4).charAt(0);

            number = number * (isBigLetter(charStart) ? (1.0 / getPosition(charStart)) : getPosition(charStart));
            number = number + ((isBigLetter(charEnd) ? -1 : 1) * getPosition(charEnd));
            sum = sum + number;
        }

        System.out.println(String.format("%.2f", sum));
    }

    private static int getPosition(int code) {
        return code < 91 ? code - 64 : code - 96;
    }

    private static boolean isBigLetter(int code) {
        return (code < 91);
    }
}
