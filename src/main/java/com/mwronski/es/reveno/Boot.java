package com.mwronski.es.reveno;

import com.google.common.base.Preconditions;
import com.mwronski.es.reveno.users.UserModule;
import com.mwronski.es.reveno.users.commands.RegisterUserCommand;
import com.mwronski.es.reveno.users.model.User;
import org.reveno.atp.api.Reveno;
import org.reveno.atp.core.Engine;

public final class Boot {

    public static void main(String... args) {
        Reveno reveno = start(args[0]);
        try {
            User newUser = new User("m-wrona", "Mike", "Wrona");
            long userId = reveno.executeSync(new RegisterUserCommand(newUser, "m-pass".toCharArray()));
            User mWrona = reveno.query().find(User.class, userId);
            Preconditions.checkNotNull(mWrona, "User hasn't been added");
            long duplicatedUserId = reveno.executeSync(new RegisterUserCommand(newUser, "m-pass".toCharArray()));
        } finally {
            reveno.shutdown();
        }
        System.exit(0);
    }

    public static Reveno start(String dir) {
        Reveno reveno = new Engine(dir);
        UserModule.init(reveno);
        reveno.startup();
        return reveno;
    }

    private Boot() {
        //no instances
    }

}
