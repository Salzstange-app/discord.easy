package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class MessageLevelManager extends ListenerAdapter implements MessageLevel, Xp{

    public static HashMap<Member, Integer> playerXp = new HashMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.isFromGuild() && event.getAuthor().isBot())return;
        if (canGetMessageXp(event.getMember())){
            setMessagePlayerTime(event.getMember(), 1);
            int oldXp = playerXp.get(event.getMember()) != null ? playerXp.get(event.getMember()) : 0;
            randXp(event.getMember(), 10);

        }
    }
}
