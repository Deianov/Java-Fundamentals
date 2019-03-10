package F_ObjectsAndClasses.MoreExercise.CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    private String getName() { return name; }
    double getSalary() { return salary; }
    String getDepartment() { return department; }

    private String getEmail() { return email; }
    void setEmail(String email) { this.email = email; }

    private int getAge() { return age; }
    void setAge(int age) { this.age = age; }

    Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
