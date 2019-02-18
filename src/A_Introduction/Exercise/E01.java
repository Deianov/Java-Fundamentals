// 01.Java-Introduction-Exercise
// 01.Ages

package A_Introduction.Exercise;

import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        String whether = age < 3 ? "baby" : age < 14 ? "child" : age < 20 ? "teenager" : age < 66 ? "adult" : "elder";
        System.out.println(whether);
    }
}
