package D_Methods.MoreExercise;

import java.util.Scanner;

public class M05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = new double[3];
        for (int i = 0; i < 3 ; i++) {
            input[i] = Double.parseDouble(scanner.nextLine());
        }
        boolean isNull = false;
        int countNegatives = 0;
        for (double num: input) {
            if (num == 0) {
                isNull = true;
            } else if (num < 0) {
                countNegatives++;
            }
        }
        if (isNull) {
            System.out.println("zero");
        } else if (countNegatives == 0 || countNegatives % 2 == 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }
}
