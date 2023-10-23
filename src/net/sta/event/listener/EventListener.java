package net.sta.event.listener;

import net.sta.event.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import net.sta.event.*;

public interface EventListener {

     void onMessageReceivedEvent(@NotNull MessageReceivedEvent event);
     void onW(@NotNull Event event);

}
