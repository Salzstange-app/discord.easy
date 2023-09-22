package net.sta.managers;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandEditAction;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.sta.events.EventPublisher;

import javax.security.auth.login.LoginException;

public class BotManager extends EventPublisher {
	
	public static JDA jda;
	
    private Activity ACTIVITY;
    private OnlineStatus ONLINESTATUS;

    public static String Prefix;

    public BotManager(String token, Activity activity, OnlineStatus onlineStatus) throws LoginException {
        this.ACTIVITY = activity;
        this.ONLINESTATUS = onlineStatus;
        createBot(token);
    }

    protected void createBot(String token) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.setChunkingFilter(ChunkingFilter.ALL);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents( GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_INVITES);
        builder.enableCache(CacheFlag.ONLINE_STATUS);

        builder.setStatus(ONLINESTATUS == null ? OnlineStatus.ONLINE : ONLINESTATUS);      
        builder.setActivity(ACTIVITY == null ? Activity.watching("Developer Salzstange") : ACTIVITY);
        
        jda = builder.build();
        setJda(jda);
        try {
            Thread.sleep(650);
        }catch (InterruptedException e){
        }

    }


    public void setEvents(Object[] eventListener) throws InterruptedException {
        jda.awaitReady().addEventListener(eventListener);
    }

    public void setPrefix(String prefix){
        Prefix = prefix;
    }

    public CommandEditAction upsertGuildCommand(String name, String desc, Object eventListener) {
        try {
            if (jda.awaitReady().getGuildById(jda.getGuilds().get(0).getId()) == null){
                return null;
            }else {
                jda.awaitReady().addEventListener(eventListener);
                Command cmd = jda.awaitReady().getGuildById(jda.getGuilds().get(0).getId()).upsertCommand(name, desc).complete();
                return cmd.editCommand();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
