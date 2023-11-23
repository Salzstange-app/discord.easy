package net.sta.event.listener;

import net.sta.event.events.Event;
import net.sta.event.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public interface EventListener {

     void onMessageReceivedEvent(@NotNull MessageReceivedEvent event);
     void onEvent(@NotNull Event event);

}
