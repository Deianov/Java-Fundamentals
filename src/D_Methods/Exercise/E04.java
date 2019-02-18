package D_Methods.Exercise;

import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        int length = password.length();
        int countDigits = 0;
        int countLetters = 0;
        for (int i = 0; i < password.length() ; i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                countDigits++;
            } else if (Character.isLetter(c)) {
                countLetters++;
            }
        }
        boolean isValid = true;
        if (length < 6 || length > 10) {
            printErrLength();
            isValid = false;
        }
        if (length > (countDigits + countLetters)) {
            printErrConsist();
            isValid = false;
        }
        if (countDigits < 2) {
            printErrDigits();
            isValid = false;
        }
        if (isValid) {
            System.out.println("Password is valid");
        }
    }
    private static void printErrLength() {
        System.out.println("Password must be between 6 and 10 characters");
    }
    private static void printErrConsist() {
        System.out.println("Password must consist only of letters and digits");
    }
    private static void printErrDigits() {
        System.out.println("Password must have at least 2 digits");
    }
}
