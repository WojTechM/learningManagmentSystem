package com.company.models.users;

public abstract class User {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String role;
    private int id;

    public User(String username, String password, String name, String surname, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }
}
