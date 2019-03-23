//01. Valid Usernames

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] data = input.split(", ");

        Arrays.stream(data)
                .filter(E01::isValid)
                .forEach(System.out::println);
    }

    private static boolean isValid(String user) {
        int length = user.length();
        if (length < 3 | length > 16) return false;

        for (int i = 0; i < length ; i++) {
            char c = user.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '-' && c != '_') {
                return false;
            }
        }
        return true;
    }
}
