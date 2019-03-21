//02. Substring

package H_TextProcessingAndRegularExpressions.Lab;

import java.util.Scanner;

public class L02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String text = scanner.nextLine();
        int index;

        while ((index = text.indexOf(key)) != -1) {
            text = text.replace(key, "");
        }
        System.out.println(text);
    }
}
