package com.eyelockgames.javamagazine.optionalDP;

public class Employee {
    int id;
    String name;
    String department;

    public Employee(int i, String name, String department) {
        this.id = i;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return this.department;
    }
}
