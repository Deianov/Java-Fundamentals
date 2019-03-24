// 07. String Explosion

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        int explosion = 0;
        boolean addExplosion = false;

        for (char c : input.toCharArray()) {
            if (addExplosion) {
                explosion += Character.getNumericValue(c);
                addExplosion = false;
            }
            if (c == '>') {
                addExplosion = true;
                stringBuilder.append(c);
            } else {
                if (explosion > 0) {
                    explosion--;
                } else {
                    stringBuilder.append(c);
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
