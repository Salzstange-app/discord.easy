package net.sta.events.listener;

import org.jetbrains.annotations.NotNull;
import net.sta.events.*;

public interface EventListener {
    void onMessageReceivedEvent(@NotNull Event event);
    void onTextChannelCreate(@NotNull Event event);
}
