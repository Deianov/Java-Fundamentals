// 07. Max Sequence of Equal Elements

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int element = 0;
        int maxSequence = 0;
        int count = 0;
        int currentElement = 0;
        for (int e:arr) {
            if (maxSequence == 0) currentElement = e;
            if (e == currentElement) {
                count++;
            } else {
                count = 1;
                currentElement = e;
            }
            if (count > maxSequence) {
                element = e;
                maxSequence = count;
            }
        }
        if (maxSequence > 1) {
            String res = element + "";
            for (int i = 0; i < maxSequence - 1 ; i++) {
                res = res + " " + element;
            }
            System.out.println(res);
        }
    }
}
