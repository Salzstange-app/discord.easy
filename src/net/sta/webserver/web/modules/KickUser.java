package net.sta.webserver.web.modules;
import net.dv8tion.jda.api.entities.Member;
import java.time.Instant;
import static net.sta.managers.BotManager.jda;

public class KickUser {


    private String uuid;
    private String reason;
    private Integer ChannelId = 12313;

    public KickUser(String userId, String kickReason){
        this.uuid = userId;
        this.reason = kickReason;
        userGetKicked();
    }


    private void userGetKicked(){
        Member member = jda.getGuilds().get(0).getMemberById(uuid);
        member.kick(reason).queue();

        if (ChannelId != null){
            jda.getGuilds().get(0).getTextChannelById("1037868392117436488").sendMessage("User: " + member.getEffectiveName() + " wurde gekickt am " + Instant.now()).queue();
        }

    }
}
