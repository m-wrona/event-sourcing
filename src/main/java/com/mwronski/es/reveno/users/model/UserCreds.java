package com.mwronski.es.reveno.users.model;

public final class UserCreds {

    private final String email;
    private final char[] password;

    public String getEmail() {
        return email;
    }

    public char[] getPassword() {
        return password;
    }

    public UserCreds(String email, char[] password) {
        this.email = email;
        this.password = password;
    }
}
