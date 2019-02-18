// 02.Data-Types-and-Variables-More-Exercise
// 01.Data Type Finder

package B_DataTypes.MoreExercise;

        import java.util.Scanner;

public class M01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            int countNumber = 0;
            int countDecimal = 0;
            int length = input.length();
            int first = input.charAt(0);
            int end = input.charAt(length - 1);
            int startMinus = (first == 45) ? 1 : 0;

            for (int i = 0; i < length ; i++) {
                int a = input.charAt(i);
                if (a == 46) countDecimal++;
                else if (a > 47 && a < 58) countNumber++;
            }
            countDecimal = countDecimal == 1 ? 1 : 0;

            String inputType;
            if (countNumber > 0 && length == countNumber + startMinus) {
                inputType = " is integer type";
            } else if (countNumber > 0 && length == countNumber + startMinus + countDecimal) {
                inputType = " is floating point type";
            } else if (length == 1) { // && first > 32
                inputType = " is character type";
            } else if (input.equals("true") || input.equals("false")) {
                inputType = " is boolean type";
            } else {
                inputType = " is string type";
            }
            System.out.println(input + inputType);
            input = scanner.nextLine();
        }
    }
}
