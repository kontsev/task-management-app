package com.example.taskmanagement.beans;

import java.time.LocalDate;
import java.util.Date;

public class Task {
    private int id;
    private String name;
    private boolean completeness;
    private LocalDate date;

    private String description;
    private String username;

    public Task(int id, String name, boolean completeness, LocalDate date, String description, String username) {
        this.id = id;
        this.name = name;
        this.completeness = completeness;
        this.date = date;
        this.description = description;
        this.username = username;
    }
    public Task(String name, boolean completeness, LocalDate date, String description, String username) {
        this.name = name;
        this.completeness = completeness;
        this.date = date;
        this.description = description;
        this.username = username;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completeness;
    }

    public void setCompleteness(boolean completeness) {
        this.completeness = completeness;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() { return description;  }
    public void setDescription(String description) { this.description = description; }

    public String getUsername() { return username; }

    public String completeToString() { return String.valueOf(completeness); }
}
