package F_ObjectsAndClasses.MoreExercise.TeamworkProjects;

import java.util.ArrayList;
import java.util.List;

class Team {

    private String name;
    private int membersCount;
    private String owner;
    private List<String> members;

    String getName() { return name; }
    int getMembersCount() { return membersCount; }
    String getOwner() { return owner; }
    List<String> getMembers() { return members; }

    Team(String name, User owner) {
        String userName = owner.getName();
        this.name = name;
        this.membersCount = 0;
        this.owner = userName;
        this.members = new ArrayList<>();
        owner.setOwner(this.name);
        System.out.printf("Team %s has been created by %s!%n", name, userName);
    }

    void addUser(User user) {
        user.setMember(this.getName());
        this.members.add(user.getName());
        this.membersCount++;
    }
}
