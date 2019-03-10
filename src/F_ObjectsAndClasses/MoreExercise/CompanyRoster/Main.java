//01. Company Roster

package F_ObjectsAndClasses.MoreExercise.CompanyRoster;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Department department = new Department();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String departmentName = data[3];

            Employee employee = new Employee(name, salary, position, departmentName);

            if (data.length > 4) {
                if (isValidMail(data[4])) employee.setEmail(data[4]);
                else employee.setAge(Integer.parseInt(data[4]));
            }
            if (data.length > 5) {
                if (isValidMail(data[5])) employee.setEmail(data[5]);
                else employee.setAge(Integer.parseInt(data[5]));
            }

            department.addEmployee(employee);
        }

        double maxAverageSalary = -1;
        String saveName = "";

        for (String name : department.getDepartments()) {
            double averageSalary = department.getAverageSalary(name);
            if (averageSalary > maxAverageSalary) {
                maxAverageSalary = averageSalary;
                saveName = name;
            }
        }

        if (maxAverageSalary > -1) {
            System.out.println("Highest Average Salary: " + saveName);
            department.getEmployeesByDepartment(saveName)
                    .stream()
                    .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                    .forEach(e -> System.out.println(e.toString()));
        }
    }

    private static boolean isValidMail(String mail) {
        return mail.contains("@") && mail.contains(".");
    }
}
