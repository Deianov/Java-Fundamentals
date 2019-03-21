//03. Reverse Strings

package H_TextProcessingAndRegularExpressions.Lab;

import java.util.Scanner;

public class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text, result;
        while (!"end".equalsIgnoreCase(text = scanner.nextLine())) {
            result = "";
            int lenght = text.length();

            while (lenght-- > 0) {
                result = result.concat(text.substring(lenght, lenght + 1));
            }
            System.out.println(text + " = " + result);
        }
    }
}
