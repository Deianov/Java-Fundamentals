package F_ObjectsAndClasses.MoreExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Department {
    private List<Employee> employees;
    private List<String> departments;

    List<String> getDepartments() {
        return departments;
    }

    Department() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    void addEmployee(Employee employee) {
        this.employees.add(employee);

        String newDepartment = employee.getDepartment();
        if (!this.departments.contains(newDepartment)) { this.departments.add(newDepartment); }
    }

    List<Employee> getEmployeesByDepartment(String departmentName) {
        return this.employees.stream().filter(e -> e.getDepartment().equals(departmentName)).collect(Collectors.toList());
    }

    double getAverageSalary(String departmentName) {
        return getEmployeesByDepartment(departmentName)
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }
}
