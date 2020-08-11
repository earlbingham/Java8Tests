package com.eyelockgames.javamagazine.optionalDP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class EmployeeService {

    public List<Employee> searchEmployee(List<Employee> employees, String name,
            Optional<String> department){

        // Null checks for employees and name
        return employees.stream()
                .filter(employee -> employee.getName().matches(name))
                .filter(employee -> employee.getDepartment().matches(department.orElse(".*")))
                .collect(toList());
    }

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        List<Employee> employees = new ArrayList<>();

        Employee a =  new Employee(1, "Mohamed Taman", "Business Development");
        employees.add(a);
        Employee b =  new Employee(1, "Malik Taman", "HR");
        employees.add(b);

        service.searchEmployee(employees, ".*", null)
                .stream()
                .forEach(System.out::println);
    }
}
