// 04. Caesar Cipher

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        Arrays.stream(input.codePoints().toArray())
                .map(e -> e + 3)
                .forEach(e -> System.out.print(Character.valueOf((char)e)));
    }
}
