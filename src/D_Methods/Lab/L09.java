package D_Methods.Lab;

import java.util.Scanner;

public class L09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String varType = scanner.nextLine();
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        switch (varType.toLowerCase()) {
            case "int" :
                System.out.println(getMax(Integer.parseInt(a), Integer.parseInt(b)));break;
            case "char" :
                System.out.println(getMax(a.charAt(0), b.charAt(0)));break;
            case "string" :
                System.out.println(getMax(a, b));
        }
    }
    private static String getMax(int a, int b) {
        return Integer.toString(Math.max(a, b));
    }
    private static String getMax(char a, char b) {
        return "" + (char)Math.max(a, b);
    }
    private static String getMax(String a, String b) {
        String result = "";
        result += (a.compareTo(b) > 0) ? a : b;
        return result;
    }
}
