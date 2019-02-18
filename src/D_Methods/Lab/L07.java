package D_Methods.Lab;

import java.util.Scanner;

public class L07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repeat = Integer.parseInt(scanner.nextLine());
        System.out.println(repeatString(input, repeat));
    }
    private static String repeatString(String str, int repeat) {
        String result = "";
        for (int i = 0; i < repeat ; i++) {
            result += str;
        }
        return result;
    }
}
