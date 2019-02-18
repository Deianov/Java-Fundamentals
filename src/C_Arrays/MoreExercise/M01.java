// 1.Encrypt, Sort and Print Array

package C_Arrays.MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class M01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        // vowels list without y, Y
        List<Integer> vowel = Arrays.asList(65, 69, 73, 79, 85, 97, 101, 105, 111, 117);
        for (int i = 0; i < n ; i++) {
            String input = scanner.nextLine();
            int code = 0;
            int length = input.length();
            for (int j = 0; j < length ; j++) {
                code += vowel.contains((int)input.charAt(j)) ? input.charAt(j) * length : input.charAt(j) / length;
            }
            arr[i] = code;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
