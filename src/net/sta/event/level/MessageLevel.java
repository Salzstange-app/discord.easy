package net.sta.event.level;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.managers.XpManager;


public class MessageLevel extends ListenerAdapter implements net.sta.event.level.Manager.MessageLevel, XpManager {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.isFromGuild() && event.getAuthor().isBot())return;
        if (canGetMessageXp(event.getMember())){
            setMessagePlayerTime(event.getMember(), 10);
            randXp(event.getMember(), 10);
        }
    }
}
