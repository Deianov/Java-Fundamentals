package F_ObjectsAndClasses.MoreExercise.TeamworkProjects;

import java.util.ArrayList;
import java.util.List;

class Users {

    private List<User> userList;

    Users() {
        this.userList = new ArrayList<>();
    }

    User getUser(String name) {
        for (User user : this.userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    void addUser(User user) {
        this.userList.add(user);
    }
}
