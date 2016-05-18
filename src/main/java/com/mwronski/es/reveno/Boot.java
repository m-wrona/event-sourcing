package com.mwronski.es.reveno;

import com.mwronski.es.reveno.users.UserModule;
import org.reveno.atp.api.Reveno;
import org.reveno.atp.core.Engine;

public final class Boot {


    public static void start(String dir) {
        Reveno reveno = new Engine(dir);
        UserModule.init(reveno);
        reveno.startup();
    }

    private Boot() {
        //no instances
    }

}
