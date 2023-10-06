package net.sta.event.textchannel;

import net.dv8tion.jda.api.JDA;
import net.sta.event.Event;

public class TextChannelCreateEvent extends Event {
    public TextChannelCreateEvent(JDA jda) {
        super(jda);
    }
}
