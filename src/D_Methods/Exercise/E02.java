package D_Methods.Exercise;

import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countVowels(scanner.nextLine()));
    }
    private static int countVowels(String abc) {
        int result = 0;
        String input = abc.toLowerCase();
        int[] volwels = {97, 101, 105, 111, 117};
        for (int i = 0; i < input.length() ; i++) {
            int digit = input.charAt(i);
            for (int j = 0; j < volwels.length ; j++) {
                if (volwels[j] == digit) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
