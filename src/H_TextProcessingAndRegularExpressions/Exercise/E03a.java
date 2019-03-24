// //03. Extract File - 80%

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03a {
    public static void main(String[] args) {
        String path = new Scanner(System.in).nextLine();

        Pattern pattern = Pattern.compile("^(?<drive>[A-Z]:)(\\/|\\\\)(?<path>[\\/\\\\\\w-]+\\2)(?<file>[\\w\\.]+)\\.(?<ext>[\\w]+)$");
        Matcher matcher = pattern.matcher(path);

        if (matcher.find()) {
            String file = matcher.group("file");
            String ext = matcher.group("ext");

            System.out.println(String.format("File name: %s", file == null ? "" : file));
            System.out.println(String.format("File extension: %s", ext == null ? "" : ext));
        }
    }
}
