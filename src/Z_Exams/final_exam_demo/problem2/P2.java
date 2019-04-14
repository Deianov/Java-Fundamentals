// 02. Deciphering
package Z_Exams.final_exam_demo.problem2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
        String[] replStr = scanner.nextLine().split("\\s");

        for (int i = 0; i < stringBuilder.length() ; i++) {
            stringBuilder.setCharAt(i, (char)(stringBuilder.charAt(i) - 3));
        }

        String book = stringBuilder.toString();

        Pattern pattern = Pattern.compile("[^a-z\\s\\{\\}\\|\\#]+");

        if (pattern.matcher(book).find()) {
            System.out.println("This is not the book you are looking for.");
        } else {
            System.out.println(book.replaceAll(replStr[0], replStr[1]));
        }
    }
}
