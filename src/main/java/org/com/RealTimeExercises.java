package org.com;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RealTimeExercises {
    public static void main(String[] args) {
        // Handle Exceptions in Streams
        List<String> numbers = List.of("1", "2", "three", "4", "a5");
        List<Integer> parsedNumbers = numbers.stream().flatMap(str -> {
            try {
                return Stream.of(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                return Stream.empty();
            }
        }).collect(Collectors.toList());
        System.out.println(parsedNumbers);

        // Group Employees by Department and Calculate Average Salary
        class Employee {
            String department;
            double salary;

            public Employee(String department, double salary) {
                this.department = department;
                this.salary = salary;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }
        }

        // Group Employees by Department and Calculate Average Salary
        List<Employee> employees = List.of(new Employee("HR", 10000),
                new Employee("HR", 20000),
                new Employee("IT", 30000));
        Map<String, Double> groupedEmployees = employees
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment(),
                        Collectors.averagingDouble(emp -> emp.getSalary())));
        System.out.println(groupedEmployees);

        // Find the Top N Highest-Paid Employees
        int n = 2;
        List<Employee> highestPaidEmployees = employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
                .limit(n)
                .collect(Collectors.toList());
        System.out.println(highestPaidEmployees);
    }
}
