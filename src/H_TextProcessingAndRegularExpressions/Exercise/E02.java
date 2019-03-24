//02. Character Multiplier

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String[] words = input.split("\\s+");
        String str1 = words[0];
        String str2 = words[1];
        int sum = 0;
        int count = Math.min(str1.length(), str2.length());

        for (int i = 0; i < count ; i++) {
            sum += str1.charAt(i) * str2.charAt(i);
        }
        sum += getSumChars(str1, count);
        sum += getSumChars(str2, count);
        System.out.println(sum);
    }

    private static int getSumChars (String word, int startIndex) {
        if (word.length() <= startIndex) {
            return 0;
        } else {
            return word.substring(startIndex).codePoints().sum();
        }
    }
}
