package B_DataTypes.Exercises;

import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double maxVolume = 0;
        String maxVolumeModel = "";
        while (n-- > 0) {
            String model = scanner.nextLine();
            double radius = Float.parseFloat(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * radius * radius * height;
            if (volume > maxVolume) {
                maxVolume = volume;
                maxVolumeModel = model;
            }
        }
        System.out.println(maxVolumeModel);
    }
}
