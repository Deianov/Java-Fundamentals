//01. Advertisement Message

package F_ObjectsAndClasses.Exercise;

import java.util.Random;
import java.util.Scanner;

public class AdvMessage {

    private Random random = new Random();

    private String[] Phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
	private String[] Events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
	private String[] Authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
	private String[] Cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    private String getPhrases() {
        return Phrases[random.nextInt(Phrases.length)];
    }
    private String getEvents() {
        return Events[random.nextInt(Events.length)];
    }
    private String getAuthors() {
        return Authors[random.nextInt(Authors.length)];
    }
    private String getCities() {
        return Cities[random.nextInt(Cities.length)];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        AdvMessage message = new AdvMessage();

        for (int i = 0; i < number ; i++) {
            System.out.printf("%s %s %s - %s%n",
                    message.getPhrases(),
                    message.getEvents(),
                    message.getAuthors(),
                    message.getCities());
        }
    }
}
