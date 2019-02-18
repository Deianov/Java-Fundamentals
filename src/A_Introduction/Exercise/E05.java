// 01.Java-Introduction-Exercise
// 05.Login

package A_Introduction.Exercise;

import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String user = input;
        String pass = "";
        for (int i = 0; i < input.length(); i++) {
            pass = input.charAt(i) + pass;
        }
        int count = 0;
        while (count++ < 5) {
            input = scanner.nextLine();
            if (input.equals(pass)) {
                System.out.printf("User %s logged in.", user);
                return;
            } else if (count == 4) {
                System.out.printf("User %s blocked!", user);
                return;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }
    }
}
