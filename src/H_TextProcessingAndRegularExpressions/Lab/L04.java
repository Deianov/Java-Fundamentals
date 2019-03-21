//04. Text Filter

package H_TextProcessingAndRegularExpressions.Lab;

        import java.util.Scanner;

public class L04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        String text = scanner.nextLine();

        for (String word : words.split(", ")) {
            text = text.replaceAll(word, repeatStr("*", word.length()));
        }

        System.out.println(text);
    }

    private static String repeatStr(String str, int repeat) {
        String result = "";
        for (int i = 0; i < repeat ; i++) {
            result = result.concat(str);
        }
        return result;
    }
}
