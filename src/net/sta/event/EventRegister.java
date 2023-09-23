package net.sta.event;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.event.events.MessageReceivedEvent;
import net.sta.event.listener.EventListener;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class EventRegister extends EventPublisher{
    public EventRegister(){}


    /*
    public void register(JDA jda){
        Event event = new Event(jda);
        MessageReceivedEvent e = new MessageReceivedEvent(jda, jda.getResponseTotal(), "test");
        for (EventListener eventListener : EventPublisher.listeners) {

            eventListener.onMessageReceivedEvent();
            eventListener.onTextChannelCreate(event);
        }
    }

     */


}
