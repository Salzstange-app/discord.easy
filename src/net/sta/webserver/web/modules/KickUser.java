package net.sta.webserver.web.modules;
import net.dv8tion.jda.api.entities.Member;
import static net.sta.managers.BotManager.jda;

public class KickUser {


    private String uuid;
    private String reason;

    public KickUser(String userId, String kickReason){
        this.uuid = userId;
        this.reason = kickReason;
        userGetKicked();
    }


    private void userGetKicked(){
        Member member = jda.getGuilds().get(0).getMemberById(uuid);
        if (reason.isEmpty()){
            member.kick().reason("Keine Begründung Angegeben");
        }else {
            member.kick().reason(reason);
        }
    }
}
