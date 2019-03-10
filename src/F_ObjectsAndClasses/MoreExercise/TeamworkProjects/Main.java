//04. Teamwork projects

package F_ObjectsAndClasses.MoreExercise.TeamworkProjects;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = Integer.parseInt(input);

        Teams teams = new Teams();
        Users users = new Users();

        for (int i = 0; i < count ; i++) {
            String[] data = scanner.nextLine().split("(-)+");
            String userName = data[0];
            String teamName = data[1];

            User user = users.getUser(userName);
            if (user == null) {
                user = new User(userName);
                users.addUser(user);
            }

            if (user.getMember() != null) {
                System.out.printf("%s cannot create another team!%n", userName);
            }

            Team team = teams.getTeam(teamName);
            if (team == null) {
                team = new Team(teamName, user);
                teams.addTeam(team);
            } else {
                System.out.printf("Team %s was already created!%n", teamName);
            }
        }

        while (!"end of assignment".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("(->)+");
            String userName = data[0];
            String teamName = data[1];

            User user = users.getUser(userName);
            if (user == null) {
                user = new User(userName);
                users.addUser(user);
            }

            Team team = teams.getTeam(teamName);

            if (team == null) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else {
                if (user.getMember() != null) {
                    System.out.printf("Member %s cannot join team %s!%n", userName, teamName);
                } else  {
                    team.addUser(user);
                }
            }
        }

        List<Team> teamDisband = teams
                .getTeamList()
                .stream()
                .filter(e -> e.getMembersCount() == 1)
                .collect(Collectors.toList());

        List<Team> teamValid = teams
                .getTeamList()
                .stream()
                .filter(e -> e.getMembersCount() > 1)
                .collect(Collectors.toList());

        teamValid.sort(Comparator.comparing(e -> e.getName()));
        teamValid.sort(Comparator.comparingInt(Team::getMembersCount).reversed());

        for (Team team : teamValid) {
            System.out.println(team.getName());
            int c = 0;
            for (User user : team.getMembers()) {
                System.out.println((c++ == 0 ? "- " : "-- ") + user.getName());
            }
        }

        System.out.println("Teams to disband:");

        for (Team team : teamDisband) {
            System.out.println(team.getName());
        }
    }
}
