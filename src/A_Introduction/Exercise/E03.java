// 01.Java-Introduction-Exercise
// 03.Vacation

package A_Introduction.Exercise;

import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double discount = 1;
        switch (group) {
            case "Students" :
                price = day.equals("Friday") ? 8.45 : day.equals("Saturday") ? 9.80 : 10.46;
                if (persons >= 30) discount = 0.85;
                break;
            case "Business" :
                price = day.equals("Friday") ? 10.9 : day.equals("Saturday") ? 15.6 : 16.0;
                if (persons >= 100) persons -= 10;
                break;
            case "Regular" :
                price = day.equals("Friday") ? 15.0 : day.equals("Saturday") ? 20.0 : 22.5;
                if (persons >= 10 && persons <= 20) discount = 0.95;
                break;
        }
        System.out.printf("Total price: %.2f", persons * price * discount);
    }
}
