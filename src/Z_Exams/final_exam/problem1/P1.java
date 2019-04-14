//Technology Fundamentals Final Exam - 14 April 2019
//Problem 1 - Arriving in Kathmandu
package Z_Exams.final_exam.problem1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "^(?<a>[A-Za-z0-9\\!\\@\\#\\$\\?]+)\\=(?<b>[0-9]+)\\<\\<(?<c>.*)$";

        Pattern pattern = Pattern.compile(regex);

        while (!(input = scanner.nextLine()).equals("Last note")) {

            Matcher matcher = pattern.matcher(input);
            int cnt = 0;
            String a = "";
            String b = "";
            String c = "";

            while (matcher.find()) {
                a = matcher.group("a");
                b = matcher.group("b");
                c = matcher.group("c");
                cnt++;
            }
            
            if (cnt == 1 && Integer.parseInt(b) == c.length()) {

//                for (char old : new char[]{'!', '@', '#', '$', '?'}) {
//                    a = a.replace(old, '\u0000');
//                }
                a = a.replaceAll("[!@#$?]", "");

                System.out.println(String.format("Coordinates found! %s -> %s", a, c));
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}
