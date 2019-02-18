package D_Methods.Exercise;

import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char from = (char)0;
        char to = (char)0;
        for (int i = 0; i < input.length() ; i++) {
            int digit = input.charAt(i);
            if (digit > 32) {
                from = (char)digit;
                break;
            }
        }
        input = scanner.nextLine();
        for (int i = 0; i < input.length() ; i++) {
            int digit = input.charAt(i);
            if(digit > 32) {
                to = (char)digit;
                break;
            }
        }
        if ((int)from != 0 && (int)to != 0) {
            if (to > from) {
                printRangeOfChars(from, to);
            } else {
                printRangeOfChars(to, from);
            }
        }
    }
    private static void printRangeOfChars(char from, char to) {
        for (int i = from + 1; i < to ; i++) {
            System.out.print((char)i + " ");
        }
    }
}
