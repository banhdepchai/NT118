package com.example.lab2_listview_customadapter;

public class Employee {
    private String id;
    private String fullName;

    private boolean isManager;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.id+" - "+this.fullName;
    }
}
