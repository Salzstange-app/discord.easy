package net.sta.events;

import net.dv8tion.jda.api.JDA;
import net.sta.events.listener.EventListener;

public class EventRegister extends EventPublisher{
    public EventRegister(){}

    public void register(JDA jda){
        Event event = new Event(jda);
        for (EventListener eventListener : EventPublisher.listeners) {
            eventListener.onMessageReceivedEvent(event);
            eventListener.onTextChannelCreate(event);
        }
    }

}
