package F_ObjectsAndClasses.MoreExercise.TeamworkProjects;

import java.util.ArrayList;
import java.util.List;

class Teams {
    private List<Team> teamList;

    Teams() {
        this.teamList = new ArrayList<>();
    }

    List<Team> getTeamList() {
        return this.teamList;
    }

    Team getTeam(String teamName) {
        for (Team team : this.teamList) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }

    void addTeam(Team team) {
        this.teamList.add(team);
    }
}
