package com.mwronski.es.reveno.users.events;

import com.mwronski.es.reveno.users.model.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class NewUserEvent {

    private final long userId;
    private final User user;
    private final char[] password;

    public User getUser() {
        return user;
    }

    public char[] getPassword() {
        return password;
    }

    public long getUserId() {
        return userId;
    }

    public NewUserEvent(long userId, User user, char[] password) {
        this.userId = userId;
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NewUserEvent that = (NewUserEvent) o;

        return new EqualsBuilder()
                .append(userId, that.userId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("user", user)
                .append("password", password)
                .toString();
    }
}
