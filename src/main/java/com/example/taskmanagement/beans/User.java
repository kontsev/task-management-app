package com.example.taskmanagement.beans;

public class User {
    private String firstname;
    private String lastname;
    private String login;
    private String password;

    public User(String firstname, String lastname, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public String getFristname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public void setName(String name) {
        this.firstname = name;
    }

    public void setSurname(String surname) {
        this.lastname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
