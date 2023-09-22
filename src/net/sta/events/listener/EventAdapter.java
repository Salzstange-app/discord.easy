package net.sta.events.listener;

import net.sta.events.Event;
import org.jetbrains.annotations.NotNull;

public abstract class EventAdapter implements EventListener {

    public void onMessageReceivedEvent(@NotNull Event event) {}
    public void onTextChannelCreate(@NotNull Event event) {}
}
