package com.mwronski.es.reveno.users.repo;

import com.mwronski.es.reveno.users.events.NewUserEvent;
import org.reveno.atp.api.transaction.TransactionContext;

public final class UserRepo {

    public static void create(NewUserEvent userEvent, TransactionContext ctx) {
        ctx.repo().store(userEvent.getUserId(), userEvent.getUser());
//        ctx.repo().store(userEvent.getUserId(), userEvent.getUser());
    }

    private UserRepo() {
        // no instances
    }

}
