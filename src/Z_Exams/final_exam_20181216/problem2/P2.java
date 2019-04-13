//02. Song Encryption
package Z_Exams.final_exam_20181216.problem2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        String regex = "^[A-Z][a-z\\'\\s]+\\:[A-Z][A-Z\\s]+$";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder stringBuilder = new StringBuilder();

        while (!(input = scanner.nextLine()).equals("end")) {

            stringBuilder.setLength(0);
            stringBuilder.append(input);

            if (pattern.matcher(input).find()) {

                String[] data = input.split(":");
                int key = data[0].length();

                for (int i = 0; i < stringBuilder.length() ; i++) {
                    char oldChar = stringBuilder.charAt(i);
                    char newChar = oldChar == ':' ? '@' : encryptByKey(key, oldChar);

                    stringBuilder.setCharAt(i, newChar);
                }
                System.out.println(String.format("Successful encryption: %s", stringBuilder.toString()));
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
    private static char encryptByKey(int key, char value) {
        if (value == ' ' || value == '\'') {
            return value;
        } else {
            int minValue = value < 97 ? 65 : 97;
            int maxValue = value < 97 ? 90 : 122;
            key = key % 26;
            int result = value + key;
            return (char)(result > maxValue ? result - 26 : result);
        }
    }
}
