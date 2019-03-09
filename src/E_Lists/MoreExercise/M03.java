//03. Take/Skip Rope

package E_Lists.MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class M03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();
        List<String> charactersList = new ArrayList<>();

        for (char c: input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbersList.add(Character.getNumericValue(c));
            } else {
                charactersList.add(Character.toString(c));
            }
        }

        List<Integer> listTake = IntStream.range(0, numbersList.size()).filter(index -> index % 2 == 0).mapToObj(numbersList::get).collect(Collectors.toList());
        List<Integer> listSkip = IntStream.range(0, numbersList.size()).filter(index -> index % 2 != 0).mapToObj(numbersList::get).collect(Collectors.toList());
        List<String> result = new ArrayList<>();

        int index = 0;
        int size = charactersList.size();

        if (size == 0 || listTake.size() == 0 ) return;

        for (int i = 0; i < listTake.size() ; i++) {
            int takeLength = listTake.get(i);
            int skipLength = listSkip.get(i);

            // take elements and return current index
            index = getCharacters(charactersList, result, index, takeLength);
            // move index with skipped positions
            index = (index + skipLength < size) ? index + skipLength : 1 + ((index + skipLength) % size);
        }

        System.out.println(String.join("", result));
    }

    private static int getCharacters(List<String> charactersList, List<String> result, int startIndex, int takeLength) {

        for (int i = 0; i < takeLength && startIndex < charactersList.size(); i++) {
            result.add(charactersList.get(startIndex++));
        }

        return startIndex;
    }
}
