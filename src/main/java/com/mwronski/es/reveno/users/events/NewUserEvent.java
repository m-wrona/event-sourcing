package com.mwronski.es.reveno.users.events;

import com.mwronski.es.reveno.users.model.User;

public final class NewUserEvent {

    private final User user;
    private final char[] password;

    public User getUser() {
        return user;
    }

    public char[] getPassword() {
        return password;
    }

    public NewUserEvent(User user, char[] password) {
        this.user = user;
        this.password = password;
    }
}
