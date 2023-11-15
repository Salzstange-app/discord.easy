package net.sta.event.events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import org.jetbrains.annotations.NotNull;

public class MessageReceivedEvent extends GenericMessageEvent {
    Message message;
    public MessageReceivedEvent(@NotNull JDA api, long responseNumber, @NotNull Message message)
    {
        super(api, responseNumber, message.getIdLong(), message.getChannel());
        this.message = message;
    }
}
