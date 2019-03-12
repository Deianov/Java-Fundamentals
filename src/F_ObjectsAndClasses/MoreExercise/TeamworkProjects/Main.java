//04. Teamwork projects

package F_ObjectsAndClasses.MoreExercise.TeamworkProjects;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = Integer.parseInt(input);
        if (count <= 0) return;

        Teams teams = new Teams();
        Users users = new Users();

        for (int i = 0; i < count ; i++) {
            String[] data = scanner.nextLine().split("(-)+");
            if (data.length < 2) continue;
            String userName = data[0];
            String teamName = data[1];
            if (userName.length() == 0 || teamName.length() == 0) continue;

            Team team = teams.getTeam(teamName);

            if (team != null) {
                System.out.printf("Team %s was already created!%n", teamName);
                continue;
            }

            User user = users.getUser(userName);

            if (user == null) {
                user = new User(userName);
                users.addUser(user);
            }

            if (user.getOwner() != null) {
                System.out.printf("%s cannot create another team!%n", userName);
                continue;
            }

            team = new Team(teamName, user);
            teams.addTeam(team);
        }

        while (!"end of assignment".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("(->)+");
            if (data.length < 2) continue;
            String userName = data[0];
            String teamName = data[1];
            if (userName.length() == 0 || teamName.length() == 0) continue;

            Team team = teams.getTeam(teamName);

            if (team == null) {
                System.out.printf("Team %s does not exist!%n", teamName);
                continue;
            }

            User user = users.getUser(userName);

            if (user == null) {
                user = new User(userName);
                users.addUser(user);
            }

            if (user.getMember() != null || user.getOwner() != null) {
                System.out.printf("Member %s cannot join team %s!%n", userName, teamName);
            } else  {
                team.addUser(user);
            }
        }
        List<Team> teamValid = new ArrayList<>();
        List<Team> teamDisband = new ArrayList<>();

        for (Team team : teams.getTeamList()) {
            if (team.getMembersCount() > 0) {
                teamValid.add(team);
            } else {
                teamDisband.add(team);
            }
        }

        teamValid.sort(Comparator.comparing(e -> e.getName()));
        teamValid.sort(Comparator.comparingInt(Team::getMembersCount).reversed());
        teamDisband.sort(Comparator.comparing(e -> e.getName()));

        for (Team team : teamValid) {
            System.out.println(team.getName());
            System.out.println("- " + team.getOwner());
            List<String> teamUsers = team.getMembers();
            Collections.sort(teamUsers);
            for (String user : teamUsers) {
                System.out.printf("-- %s%n", user);
            }
        }

        System.out.println("Teams to disband:");

        for (Team team : teamDisband) {
            System.out.println(team.getName());
        }
    }
}
