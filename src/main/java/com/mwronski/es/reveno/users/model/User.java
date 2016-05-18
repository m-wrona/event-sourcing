package com.mwronski.es.reveno.users.model;

public final class User {

    private final long id;
    private final String login;
    private final String firstName;
    private final String lastName;

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public User(long id, String login, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
