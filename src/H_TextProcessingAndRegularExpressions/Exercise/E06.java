// 06. Replace Repeating Chars

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        if (input.length() < 2) {
            System.out.println(input);
            return;
        }

        char temp = input.charAt(0);

        for (int i = 1; i < input.length() ; i++) {
            char c = input.charAt(i);
            if (temp != c) {
                stringBuilder.append(temp);
                temp = c;
            }
        }
        stringBuilder.append(temp);
        System.out.println(stringBuilder);
    }
}
