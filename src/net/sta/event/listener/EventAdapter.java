package net.sta.event.listener;

import net.sta.event.Event;
import net.sta.event.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public abstract class EventAdapter implements EventListener {

    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {}
    public void onW(@NotNull Event event) {}

}
