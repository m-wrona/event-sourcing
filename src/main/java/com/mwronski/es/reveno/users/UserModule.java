package com.mwronski.es.reveno.users;

import com.mwronski.es.reveno.users.commands.RegisterUserCommand;
import com.mwronski.es.reveno.users.events.NewUserEvent;
import com.mwronski.es.reveno.users.repo.UserRepo;
import org.reveno.atp.api.Reveno;

public final class UserModule {

    public static void init(Reveno reveno) {
        reveno.domain().command(NewUserEvent.class, RegisterUserCommand::handle);
        reveno.domain().transactionAction(NewUserEvent.class, UserRepo::create);
    }

    private UserModule() {
        //no instances
    }
}
