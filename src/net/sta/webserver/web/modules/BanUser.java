package net.sta.webserver.web.modules;

import net.dv8tion.jda.api.entities.Member;

import java.util.concurrent.TimeUnit;

import static net.sta.managers.BotManager.jda;

public class BanUser {

    private String uuid;
    private String reason;

    public BanUser(String userId, String kickReason){
        this.uuid = userId;
        this.reason = kickReason;
        userGetKicked();
    }


    private void userGetKicked(){
        Member member = jda.getGuilds().get(0).getMemberById(uuid);
        if (reason.isEmpty()){
            member.ban(1, TimeUnit.DAYS).reason("Keine Begründung Angegeben");
        }else {
            member.ban(2, TimeUnit.DAYS).reason(reason);
        }
    }
}
