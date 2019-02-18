// 02. Pascal Triangle

package C_Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class M02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[] previous = new int[1];

        for (int i = 0; i < rows ; i++) {
            int[] row = new int[i + 1];
            row[0] = 1;
            row[i] = 1;
            for (int j = 1; j < previous.length; j++) {
                row[j] = previous[j-1] + previous[j];
            }
            System.out.println();
            for (int j = 0; j < row.length ; j++) {
                System.out.print(row[j] + " ");
            }
            previous = Arrays.copyOf(row,row.length);
        }
    }
}
