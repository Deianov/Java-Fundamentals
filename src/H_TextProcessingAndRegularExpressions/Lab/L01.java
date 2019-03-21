//01. Repeat strings

package H_TextProcessingAndRegularExpressions.Lab;

import java.util.Scanner;

public class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";

        for (String str : input.split(" ")) {
            int count = str.length();

            while (count-- > 0) result += str;
        }


        System.out.println(result);
    }
}
