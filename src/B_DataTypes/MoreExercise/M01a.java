// 1. Data Type Finder

package B_DataTypes.MoreExercise;

import java.util.Scanner;

public class M01a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String inputType;
        while (!input.equals("END")) {
            inputType = "";
            try {
                Integer.parseInt(input);
                inputType = "integer";
            } catch (Exception e) {}

            if (inputType.isEmpty()) {
                try {
                    Float.parseFloat(input);
                    inputType = "floating point";
                } catch (Exception e) {}
            }
            if (inputType.isEmpty()) {
                if (input.length() <= 1) inputType = "character";
                else if (input.toLowerCase().equals("true") || input.toLowerCase().equals("false")) inputType = "boolean";
                else inputType = "string";
            }
            System.out.printf("%s is %s type%n", input, inputType);
            input = scanner.nextLine();
        }
    }
}
