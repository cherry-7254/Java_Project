package com.example.library.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String id;
    private String name;
    private Set<String> borrowedBookIds = new HashSet<>();

    public User() {}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBorrowedBookIds() {
        return borrowedBookIds;
    }

    public void setBorrowedBookIds(Set<String> borrowedBookIds) {
        this.borrowedBookIds = borrowedBookIds;
    }
}
