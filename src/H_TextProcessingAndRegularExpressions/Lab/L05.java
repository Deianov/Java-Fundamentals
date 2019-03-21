//05. Digits, Letters and Other

package H_TextProcessingAndRegularExpressions.Lab;

import java.util.Scanner;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int length = input.length();

        StringBuilder builderNumber = new StringBuilder(length);
        StringBuilder builderLetter = new StringBuilder(length);
        StringBuilder builderCharacters = new StringBuilder(length);

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) builderNumber.append(c);
            else if (Character.isLetter(c)) builderLetter.append(c);
            else builderCharacters.append(c);
        }
        System.out.println(builderNumber);
        System.out.println(builderLetter);
        System.out.println(builderCharacters);
    }
}
