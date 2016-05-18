package com.mwronski.es.reveno.users.commands;

import com.mwronski.es.reveno.users.events.NewUserEvent;
import com.mwronski.es.reveno.users.model.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.reveno.atp.api.commands.CommandContext;

public final class RegisterUserCommand {

    private final User user;
    private final char[] password;

    public static void handle(RegisterUserCommand command, CommandContext ctx) {
        long userId = ctx.id(User.class);
        if (ctx.repo().has(User.class, userId)) {
            throw new RuntimeException("User already exists: " + command);
        }
        ctx.executeTxAction(new NewUserEvent(userId, command.getUser(), command.getPassword()));
    }

    public User getUser() {
        return user;
    }

    public char[] getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("user", user)
                .append("password", password)
                .toString();
    }

    public RegisterUserCommand(User user, char[] password) {
        this.user = user;
        this.password = password;
    }
}
