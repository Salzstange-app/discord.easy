package net.sta.commands;

import net.sta.event.listener.EventAdapter;
import net.sta.event.message.MessageReceivedEvent;
import net.sta.managers.LevelManager;
import org.jetbrains.annotations.NotNull;

public class levelCommand extends EventAdapter {
    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().equals("!test")){
            String st = LevelManager.getPlayerXP(event.getMessage().getMember()).toString();
            event.sendMessage(st);
        }

    }

}
