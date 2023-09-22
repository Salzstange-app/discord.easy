package test.Event;

import java.util.EventListener;

public interface DiscordListener extends EventListener {
    public abstract void textChannelCreateEvent(DiscordEvent e);
}
