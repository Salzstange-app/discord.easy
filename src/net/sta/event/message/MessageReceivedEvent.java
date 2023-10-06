package net.sta.event.message;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.sta.event.Event;

@Getter
public class MessageReceivedEvent extends Event implements net.sta.event.message.Message {

    public Message message = MessageGetter.Message;
    public MessageReceivedEvent(JDA jda) {
        super(jda);
    }
}
