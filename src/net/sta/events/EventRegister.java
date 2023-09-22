package net.sta.events;

import net.sta.events.listener.EventListener;

public class EventRegister extends EventPublisher{
    public EventRegister(){}

    public void register(){
        Event event = new Event(jda);
        for (EventListener eventListener : EventPublisher.listeners) {
            eventListener.onMessageReceivedEvent(event);
            eventListener.onTextChannelCreate(event);
        }
    }

}
