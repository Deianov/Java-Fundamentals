//10. SoftUni Course Planning

package E_ArrayList.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E10 {
    private static String suffixEXERCISE = "-Exercise";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> courseLessons = new ArrayList<>(Arrays.asList(input.split(", ")));

        while (!"course start".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] line = input.split(":");
            String command = line[0].toLowerCase();
            String title = line[1];
            int index;
            String secondTitle;

            switch (command) {
                case "add":
                    if (!courseLessons.contains(title)) {
                        courseLessons.add(title);
                    }
                    break;
                case "insert":
                    index = Integer.parseInt(line[2]);
                    insertTitleToIndex(courseLessons, title, index);
                    break;
                case "remove":
                    removeTitleFromList(courseLessons, title);
                    break;
                case "swap":
                    secondTitle = line[2];
                    swapTitlesInList(courseLessons, title, secondTitle);
                    break;
                case "exercise":
                    addExerciseTitle(courseLessons, title);
                    break;
            }
        }

        printArrayListNewLines(courseLessons);
    }

    private static void addExerciseTitle(List<String> stringList, String title) {
        int titleIndex = getTitleIndex(stringList, title);

        if (titleIndex >= 0) {
            insertTitleToIndex(stringList, title + suffixEXERCISE, titleIndex + 1);
        } else if (titleIndex == -1) {
            if (getTitleIndex(stringList, title + suffixEXERCISE) == -1) {
                stringList.add(title);
                stringList.add(title + suffixEXERCISE);
            }
        }
    }

    private static void swapTitlesInList(List<String> stringList, String firstTitle, String secondTitle) {
        int firstIndex = getTitleIndex(stringList, firstTitle);
        int firstExerciseIndex = getTitleIndex(stringList, firstTitle + suffixEXERCISE);
        int secondIndex = getTitleIndex(stringList, secondTitle);
        int secondExerciseIndex = getTitleIndex(stringList, secondTitle + suffixEXERCISE);
        String temp;
        if (firstIndex >= 0 && secondIndex >= 0 && firstIndex != secondIndex) {

            // swap Titles
            temp = stringList.get(firstIndex);
            stringList.set(firstIndex, stringList.get(secondIndex));
            stringList.set(secondIndex, temp);

            // move Exercises
            if (firstExerciseIndex == firstIndex + 1 && secondExerciseIndex == secondExerciseIndex + 1) {
                temp = stringList.get(firstIndex + 1);
                stringList.set(firstIndex + 1, stringList.get(secondIndex + 1));
                stringList.set(secondIndex + 1, temp);
            } else if (firstExerciseIndex == firstIndex + 1) {
                stringList.remove(firstExerciseIndex);
                firstIndex = getTitleIndex(stringList, firstTitle);
                insertTitleToIndex(stringList, firstTitle + suffixEXERCISE, firstIndex + 1);
            } else if (secondExerciseIndex == secondIndex + 1) {
                stringList.remove(secondExerciseIndex);
                secondIndex = getTitleIndex(stringList, secondTitle);
                insertTitleToIndex(stringList, secondTitle + suffixEXERCISE, secondIndex + 1);
            }
        }
    }

    private static int getTitleIndex(List<String> stringList, String title) {
        int count = 0;
        int index = -1;
        for (int i = 0; i < stringList.size() ; i++) {
            if (stringList.get(i).equalsIgnoreCase(title)) {
                count++;
                index = i;
            }
        }
        return count > 1 ? -2 : index;
    }


    private static void removeTitleFromList(List<String> stringList, String title) {
        String lastRemovedTitle = null;
        int lastRemovedIndex = -1;
        for (int i = 0; i < stringList.size() ; i++) {
            if (stringList.get(i).equalsIgnoreCase(title)) {
                lastRemovedTitle = title;
                lastRemovedIndex = i;
                stringList.remove(i--);
            }
            if (i == lastRemovedIndex) {
                if (stringList.get(i).equalsIgnoreCase(lastRemovedTitle + suffixEXERCISE)) {
                    stringList.remove(i--);
                    lastRemovedIndex = -1;
                }
            }
        }
    }

    private static void insertTitleToIndex(List<String> stringList, String title, int index) {
        if (getTitleIndex(stringList, title) == -1) {
            if (index >= 0 && index < stringList.size()) {
                stringList.add(index, title);
            } else if (index == stringList.size()) {
                stringList.add(title);
            }
        }
    }

    private static void printArrayListNewLines(List<String> stringList) {
        int i = 1;
        for (String e: stringList) {
            System.out.println(i++ + "." + e);
        }
    }
}
