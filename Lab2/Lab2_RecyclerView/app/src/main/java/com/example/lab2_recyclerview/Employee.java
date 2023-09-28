package com.example.lab2_recyclerview;

public class Employee {

    private final String id;
    private final String fullName;
    private final boolean isManager;

    public Employee(String id, String fullName, boolean isManager) {
        this.id = id;
        this.fullName = fullName;
        this.isManager = isManager;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isManager() {
        return isManager;
    }
}
