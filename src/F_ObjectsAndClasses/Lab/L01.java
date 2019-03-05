//01. Randomize Words

package F_ObjectsAndClasses.Lab;

import java.util.Random;
import java.util.Scanner;

public class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Random rnd = new Random();

        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = rnd.nextInt(words.length);
            swap(words, pos1, pos2);
        }

        System.out.println(String.join(System.lineSeparator(), words));
    }

    private static void swap(String[] stringsArray, int i, int j) {
        int len = stringsArray.length;
        if (i >= 0 && i < len && j >= 0 && j < len && i != j) {
            String temp = stringsArray[i];
            stringsArray[i] = stringsArray[j];
            stringsArray[j] = temp;
        }
    }
}
