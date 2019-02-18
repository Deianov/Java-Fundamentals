package A_Introduction.MoreExercise;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = "";
        for ( char a: input.toCharArray()) {
            output = a + output;
        }
        System.out.println(output);
    }
}
