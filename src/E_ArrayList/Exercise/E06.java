// 06. Cards Game

package E_ArrayList.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> topCards = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> bottomCards = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        boolean hasWinner = false;
        while (!hasWinner) {
            hasWinner = gameRound(topCards, bottomCards);
        }

        printPlayerScore(topCards, "First");
        printPlayerScore(bottomCards, "Second");
    }

    private static void printPlayerScore(List<Integer> cards, String name) {
        int sum = 0;
        int length = cards.size();

        for (int card: cards) {
            sum += card;
        }

        if (length > 0) {
            System.out.printf("%s player wins! Sum: %d", name, sum);
        }
    }

    private static boolean gameRound(List<Integer> topCards, List<Integer> bottomCards) {
        List<Integer> topHands = new ArrayList<>();
        List<Integer> bottomHands = new ArrayList<>();
        int hands = Math.min(topCards.size(), bottomCards.size());

        while (hands-- > 0) {
            int topCard = topCards.get(0);
            int bottomCard = bottomCards.get(0);
            if (topCard > bottomCard) {
                topHands.add(topCard);
                topHands.add(bottomCard);
            } else if (topCard < bottomCard) {
                bottomHands.add(bottomCard);
                bottomHands.add(topCard);
            }
            topCards.remove(0);
            bottomCards.remove(0);
        }
        topCards.addAll(topHands);
        bottomCards.addAll(bottomHands);

        return (topCards.size() == 0) || (bottomCards.size() == 0);
    }
}
