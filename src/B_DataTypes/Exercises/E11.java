package B_DataTypes.Exercises;

import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = -1;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;
        while (n-- > 0) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());
            double value = Math.pow((double)snow / (double)time, quality);
            if (value > maxValue) {
                maxValue = value;
                maxSnow = snow;
                maxTime = time;
                maxQuality = quality;
            }
        }
        if (maxValue > -1) System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, maxValue, maxQuality);
    }
}
