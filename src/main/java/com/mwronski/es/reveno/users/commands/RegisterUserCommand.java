package com.mwronski.es.reveno.users.commands;

import com.mwronski.es.reveno.users.events.NewUserEvent;
import com.mwronski.es.reveno.users.model.User;
import org.reveno.atp.api.commands.CommandContext;

public final class RegisterUserCommand {

    public static void handle(NewUserEvent command, CommandContext ctx) {
        if (!ctx.repo().has(User.class, command.getUser().getId())) {
            throw new RuntimeException("User already exist: " + command.getUser().getLogin());
        }
        //TODO
    }

}
