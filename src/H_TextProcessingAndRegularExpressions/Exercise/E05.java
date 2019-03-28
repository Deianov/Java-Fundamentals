// 05. Multiply Big Number

package H_TextProcessingAndRegularExpressions.Exercise;

        import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine()).reverse();
        int multiply = Integer.parseInt(scanner.nextLine());
        int temp = 0;
        if (multiply == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < stringBuilder.length() ; i++) {
            int digit = Character.getNumericValue(stringBuilder.charAt(i));
            int sum = (digit * multiply) + temp;
            int newDigit = sum % 10;
            temp = sum / 10;
            stringBuilder.setCharAt(i, (char)(48 + newDigit));
        }

        if(temp > 0) {
            stringBuilder.append(temp);
        }

        System.out.println(stringBuilder.reverse().toString());
    }
}
