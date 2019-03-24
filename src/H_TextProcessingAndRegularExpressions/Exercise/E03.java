//03. Extract File

package H_TextProcessingAndRegularExpressions.Exercise;

import java.io.File;
import java.util.Scanner;

public class E03 {
    // The Unix separator character.
    private static char UNIX_SEPARATOR = '/';
    // The Windows separator character.
    private static char WINDOWS_SEPARATOR = '\\';
    // The extension separator character.
    private static char EXTENSION_SEPARATOR = '.';
    // The system separator character.
    private static char SYSTEM_SEPARATOR = File.separatorChar;


    public static void main(String[] args) {
        String path = new Scanner(System.in).nextLine();

        String file = getFile(path);
        String fileName = getFileName(file);
        String fileExtension = getFileExtension(file);

        if (file != null) {
            System.out.println(String.format("File name: %s", fileName == null ? "" : fileName));
            System.out.println(String.format("File extension: %s", fileExtension == null ? "" : fileExtension));
        }
    }

    private static String getFile (String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        return path.substring(Math.max(path.lastIndexOf(UNIX_SEPARATOR), path.lastIndexOf(WINDOWS_SEPARATOR)) + 1);
    }

    private static String getFileName(String file) {
        if(file == null || file.length() == 0) {
            return null;
        }
        int lastIndexOf = file.lastIndexOf(EXTENSION_SEPARATOR);
        return lastIndexOf == -1 ? null : file.substring(0, lastIndexOf);
    }

    private static String getFileExtension(String file) {
        if(file == null || file.length() == 0) {
            return null;
        }
        int lastIndex = file.lastIndexOf(EXTENSION_SEPARATOR);
        return lastIndex == -1 ? null : file.substring(lastIndex + 1);
    }
}
