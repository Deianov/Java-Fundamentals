//Problem 1 – Concert
package Z_Exams.final_exam_20181216.problem1;

import java.util.*;

public class P1v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, List<String>> bandsMembers = new LinkedHashMap<>();
        Map<String, Long> bandsTimes = new LinkedHashMap<>();

        while (!(input = scanner.nextLine()).equals("start of concert")) {
            String[] data = input.split(";\\s");
            String bandName = data[1];
            String command = data[0];

            if (command.equals("Add")) {
                String[] newMembers = data[2].split(",\\s");

                bandsMembers.putIfAbsent(bandName, new ArrayList<>());
                bandsTimes.putIfAbsent(bandName, 0l);
                List<String> members = bandsMembers.get(bandName);

                for (String member : newMembers) {
                    if (!members.contains(member)) {
                        members.add(member);
                    }
                }
            } else if (command.equals("Play")) {
                int time = Integer.parseInt(data[2]);

                bandsMembers.putIfAbsent(bandName, new ArrayList<>());
                bandsTimes.putIfAbsent(bandName, 0l);
                bandsTimes.put(bandName, bandsTimes.get(bandName) + time);
            }
        }

        long totalTime = bandsTimes.values().stream().mapToLong(Long::longValue).sum();
        System.out.println("Total time: " + totalTime);

        bandsTimes.entrySet()
                .stream()
                .sorted((b1, b2) -> {
                    long sort = b2.getValue() - b1.getValue();
                    return sort == 0 ? b1.getKey().compareTo(b2.getKey()) : (int)sort;
                })
                .forEach(b -> System.out.println(b.getKey() + " -> " + b.getValue()));

        input = scanner.nextLine();

        System.out.println(input);
        for (String member : bandsMembers.get(input)) {
            System.out.println("=> " + member);
        }
    }
}
