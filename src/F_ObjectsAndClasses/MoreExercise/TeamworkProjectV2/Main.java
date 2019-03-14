package F_ObjectsAndClasses.MoreExercise.TeamworkProjectV2;

//04. Teamwork projects by Ivan Yonkov

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();
        List<String> members = new ArrayList<>();

        int teamSize = Integer.parseInt(sc.nextLine());

        while (teamSize-->0) {
            String[] creatorAndTeam = sc.nextLine().split("-");
            String creator = creatorAndTeam[0];
            String teamName = creatorAndTeam[1];
            if (teams.stream().anyMatch(t -> t.getName().equalsIgnoreCase(teamName))) {
                System.out.printf("Team %s was already created!%n", teamName);
                continue;
            }

            if (members.contains(creator)) {
                System.out.printf("%s cannot create another team!%n", creator);
                continue;
            }

            Team team = new Team(teamName, creator);
            teams.add(team);
            members.add(creator);
            System.out.printf("Team %s has been created by %s!%n", teamName, creator);
        }

        String line = sc.nextLine();

        while (!line.equalsIgnoreCase("end of assignment")) {
            String[] memberAndTeam = line.split("->");
            String member = memberAndTeam[0];
            String teamName = memberAndTeam[1];
            Team team = teams.stream().filter(t -> t.getName().equals(teamName))
                    .findFirst().orElse(null);

            if (team == null) {
                System.out.printf("Team %s does not exist!%n", teamName);
                line = sc.nextLine();
                continue;
            }

            if (members.contains(member)) {
                System.out.printf("Member %s cannot join team %s!%n", member, teamName);
                line = sc.nextLine();
                continue;
            }

            team.addMember(member);
            members.add(member);

            line = sc.nextLine();
        }

        teams
                .stream()
                .filter(team -> !team.isDisband())
                .sorted(
                        Comparator.comparing(team -> ((Team)team).size())
                                .reversed()
                                .thenComparing(team -> ((Team)team).getName())
                )
                .forEach(System.out::println);

        System.out.println("Teams to disband:");
        teams
                .stream()
                .filter(Team::isDisband)
                .map(Team::getName)
                .sorted()
                .forEach(System.out::println);
    }

}


class Team {
    private String name;
    private String creator;

    private List<String> members;

    public Team(String name, String leader) {
        this.name = name;
        this.creator = leader;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addMember(String member) {
        this.members.add("-- " + member);
    }

    public boolean isDisband() {
        return this.members.size() == 0;
    }

    public int size() {
        return this.members.size();
    }

    @Override
    public String toString() {
        Collections.sort(this.members);
        return this.getName() +
                System.lineSeparator() +
                "- " +
                this.creator +
                System.lineSeparator() +
                String.join(System.lineSeparator(), this.members);
    }
}