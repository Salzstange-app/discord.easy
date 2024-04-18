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
import net.sta.event.EventPublisher;
import net.sta.event.level.MessageLevel;
import net.sta.event.level.VoiceLevel;
import net.sta.event.message.MessageGetter;

import java.util.Objects;

public class BotManager extends EventPublisher {
	
	public static JDA jda;
	
    private final Activity ACTIVITY;
    private final OnlineStatus ONLINESTATUS;

    public static String Prefix;

    public BotManager(String token, Activity activity, OnlineStatus onlineStatus) {
        this.ACTIVITY = activity;
        this.ONLINESTATUS = onlineStatus;
        createBot(token);
    }

    protected void createBot(String token)  {
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
        builder.addEventListeners(new MessageGetter());
        builder.addEventListeners(new MessageLevel(), new VoiceLevel());
        builder.setStatus(ONLINESTATUS == null ? OnlineStatus.ONLINE : ONLINESTATUS);      
        builder.setActivity(ACTIVITY == null ? Activity.watching("Developer Salzstange") : ACTIVITY);
        jda = builder.build();
        //Wird benötigt um das LevelSystem zu benutzen.
        builder.addEventListeners(new MessageLevel());
        builder.addEventListeners(new MessageGetter());

        try {
            Thread.sleep(650);
        }catch (InterruptedException ignored){
        }

    }




    public void setPrefix(String prefix){
        Prefix = prefix;
    }

    @SuppressWarnings("unused")
    public CommandEditAction upsertGuildCommand(String name, String desc, Object eventListener) {
        try {
            if (jda.awaitReady().getGuildById(jda.getGuilds().get(0).getId()) == null){
                return null;
            }else {
                jda.awaitReady().addEventListener(eventListener);
                Command cmd = Objects.requireNonNull(jda.awaitReady().getGuildById(jda.getGuilds().get(0).getId())).upsertCommand(name, desc).complete();
                return cmd.editCommand();
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
