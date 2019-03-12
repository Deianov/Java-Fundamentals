package F_ObjectsAndClasses.MoreExercise.TeamworkProjects;

class User {

    private String name;
    private String owner;
    private String member;

    public String getName() { return name; }
    void setOwner(String owner) { this.owner = owner; }
    String getOwner() { return owner; }
    String getMember() { return member; }
    void setMember(String member) { this.member = member; }

    User(String name) {
        this.name = name;
        this.owner = null;
        this.member = null;
    }
}
