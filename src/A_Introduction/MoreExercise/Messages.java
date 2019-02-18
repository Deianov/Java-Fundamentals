package A_Introduction.MoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int typing = Integer.parseInt(scanner.nextLine());
        String result = "";
        String input;
        int digitsLength ;
        int digitMain;
        int letterIndex;
        for (int i = 0; i < typing ; i++) {
            input = scanner.nextLine();
            digitsLength  = input.length();
            digitMain = Integer.parseInt(input) % 10;
            if (digitMain > 1) {
                letterIndex = 97 + ((digitMain - 2) * 3) + digitsLength - 1;
                if (digitMain > 7) letterIndex++;
            } else {
                letterIndex = digitMain == 0 ? 32 : 0;
            }
            result = result + (char)letterIndex;
        }
        System.out.println(result);
    }
}
