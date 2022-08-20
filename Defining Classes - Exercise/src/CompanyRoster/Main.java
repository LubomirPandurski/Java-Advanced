package CompanyRoster;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfEmployee = Integer.parseInt(scanner.nextLine());
        new ArrayList();
        List<Department> departmentList = new ArrayList();

        for(int i = 0; i < countOfEmployee; ++i) {
            String[] employeeInfo = scanner.nextLine().split(" ");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;
            switch(employeeInfo.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (employeeInfo[4].matches("\\d+")) {
                        int personAge = Integer.parseInt(employeeInfo[4]);
                        employee = new Employee(name, salary, position, department, personAge);
                    } else {
                        String personEmail = employeeInfo[4];
                        employee = new Employee(name, salary, position, department, personEmail);
                    }
                    break;
                case 6:
                    String email = employeeInfo[4];
                    int age = Integer.parseInt(employeeInfo[5]);
                    employee = new Employee(name, salary, position, department, email, age);
            }

            boolean departmentExists = departmentList.stream().filter((dep) -> {
                return dep.getName().equals(department);
            }).count() >= 1L;
            if (!departmentExists) {
                departmentList.add(new Department(department));
            }

            Department currentDepartment = (Department)departmentList.stream().filter((dep) -> {
                return dep.getName().equals(department);
            }).findFirst().get();
            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = (Department)departmentList.stream().max(Comparator.comparingDouble((departmentx) -> {
            return departmentx.calculateAverageSalary();
        })).get();
        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());
        Stream var10000 = highestPaidDepartment.getEmployees().stream().sorted((e1, e2) -> {
            return Double.compare(e2.getSalary(), e1.getSalary());
        });
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }
}

