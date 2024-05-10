package net.sta.event.message;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.event.listener.EventListener;

import static net.sta.event.EventPublisher.listeners;

public class MessageGetter extends ListenerAdapter {

	public static Message Message = null;
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Message = event.getMessage();
		System.out.println(Message);
		if (!event.getAuthor().isBot()){
			for (EventListener listener : listeners) {
				listener.onMessageReceivedEvent(new net.sta.event.message.MessageReceivedEvent(event.getJDA()));
			}
		}

	}
}
