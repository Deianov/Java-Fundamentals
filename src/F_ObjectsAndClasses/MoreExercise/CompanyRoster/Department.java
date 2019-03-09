package F_ObjectsAndClasses.MoreExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private List<Employee> employees;
    private List<String> departments;

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public Department() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);

        String newDepartment = employee.getDepartment();
        if (!this.departments.contains(newDepartment)) { this.getDepartments().add(newDepartment); }
    }

    public List<Employee> getEmployeesByDepartment(String departmentName) {
        return this.getEmployees().stream().filter(e -> e.getDepartment().equalsIgnoreCase(departmentName)).collect(Collectors.toList());
    }

    public double getAverageSalary(String departmentName) {
        return getEmployeesByDepartment(departmentName)
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }
}
