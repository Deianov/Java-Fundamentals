// 5. Decrypting Messages

package B_DataTypes.MoreExercise;

import java.util.Scanner;

public class M05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int cnt = Integer.parseInt(scanner.nextLine());
        String letter = "";
        while (cnt-- > 0) {
            letter += (char) (scanner.nextLine().charAt(0) + key);
        }
        System.out.println(letter);
    }
}
