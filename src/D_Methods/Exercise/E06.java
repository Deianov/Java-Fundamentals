package D_Methods.Exercise;

import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() > 0) {
            System.out.println(getMiddleCharacter(input));
        }
    }
    private static String getMiddleCharacter(String s) {
        String result = "";
        int length = s.length();
        if (length % 2 == 0) {
            result = "" + s.charAt(length / 2 - 1) + s.charAt(length / 2 );
        } else {
            result = "" + s.charAt(length / 2);
        }
        return result;
    }
}
