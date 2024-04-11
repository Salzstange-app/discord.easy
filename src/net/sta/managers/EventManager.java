package net.sta.managers;

import net.dv8tion.jda.api.events.GenericEvent;

import java.util.List;

public interface EventManager {

    void register(Object listener);

    void unregister(Object listener);

    void handle(GenericEvent event);
    List<Object> getRegisteredListeners();
}
