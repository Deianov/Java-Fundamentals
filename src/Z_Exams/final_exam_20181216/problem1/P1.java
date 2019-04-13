//Problem 1 – Concert
package Z_Exams.final_exam_20181216.problem1;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, Band> bandMap = new LinkedHashMap<>();

        while (!(input = scanner.nextLine()).equals("start of concert")) {
            String[] data = input.split(";\\s");
            String command = data[0];
            String bandName = data[1];

            if (command.equals("Add") || command.equals("Play")) {

                bandMap.putIfAbsent(bandName, new Band(bandName));
                Band band = bandMap.get(bandName);
                List<String> members = band.getMembers();

                if(command.equals("Add")) {
                    for (String member : data[2].split(",\\s")) {
                        if (!members.contains(member)) {
                            members.add(member);
                        }
                    }
                } else {
                    int time = Integer.parseInt(data[2]);
                    band.setTime(band.getTime() + time);
                }
            }
        }

        long totalTime = bandMap.values().stream().mapToLong(Band::getTime).sum();
        System.out.println("Total time: " + totalTime);

        bandMap.values()
                .stream()
                .sorted(Comparator.comparingLong(Band::getTime).reversed()
                        .thenComparing(Band::getName))
                .forEach(b -> System.out.printf("%s -> %d%n", b.getName(), b.getTime()));

        Band band = bandMap.get(scanner.nextLine());
        System.out.println(band.getName());
        for (String member : band.getMembers()) {
            System.out.println("=> " + member);
        }
    }
}

class Band {

    private String name;
    private List<String> members;
    private long time;

    public Band(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.time = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
