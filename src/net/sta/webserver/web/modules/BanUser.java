package net.sta.webserver.web.modules;

import net.dv8tion.jda.api.entities.Member;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import static net.sta.managers.BotManager.jda;

public class BanUser {

    private String uuid;
    private String reason;

    private Integer ChannelId = 123123;

    public BanUser(String userId, String bannreason){
        this.uuid = userId;
        this.reason = bannreason;
        userGetBanned();
    }

    private void userGetBanned(){

        Member member = jda.getGuilds().get(0).getMemberById(uuid);
        member.ban(1, TimeUnit.DAYS).reason(reason).queue();

        if (ChannelId != null){
            jda.getGuilds().get(0).getTextChannelById("1037868392117436488").sendMessage("User: " + member.getEffectiveName() + " wurde gebannt am " + Instant.now()).queue();
        }
    }
}
