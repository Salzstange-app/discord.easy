package net.sta.event.level;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.event.listener.EventAdapter;
import net.sta.event.message.MessageReceivedEvent;
import net.sta.managers.XpManager;
import org.jetbrains.annotations.NotNull;


public class MessageLevel extends EventAdapter implements net.sta.event.level.Manager.MessageLevel, XpManager {
    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getAuthor().isBot())return;
        if (canGetMessageXp(event.getMessage().getMember())){
            setMessagePlayerTime(event.getMessage().getMember(), 10);
            randXp(event.getMessage().getMember(), 10);
        }
    }
}
