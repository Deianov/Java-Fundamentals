package D_Methods.Exercise;

import java.util.Scanner;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"END".equalsIgnoreCase(input = scanner.nextLine())) {
            System.out.println(input.equals(reverse(input)) ? "true" : "false");
        }
    }
    private static String reverse(String s) {
        String result = "";
        for (int i = 0; i < s.length() ; i++) {
            result = s.charAt(i) + result;
        }
        return result;
    }
}
