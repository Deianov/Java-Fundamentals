package F_ObjectsAndClasses.MoreExercise.TeamworkProjects;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private int membersCount;
    private User owner;
    private List<User> members;

    public String getName() { return name; }
    int getMembersCount() { return membersCount; }
    List<User> getMembers() { return members; }

    Team(String name, User owner) {
        this.name = name;
        this.membersCount = 1;
        this.owner = owner;
        this.members = new ArrayList<>();
        this.members.add(owner);
        owner.setOwner(this.name);
        owner.setMember(this.name);
        System.out.printf("Team %s has been created by %s!%n", name, owner.getName());
    }

    void addUser(User user) {
        user.setMember(this.getName());
        this.members.add(user);
        this.membersCount++;
    }
}
