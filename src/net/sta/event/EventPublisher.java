package net.sta.event;

import net.dv8tion.jda.api.JDA;
import net.sta.event.listener.EventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventPublisher {

    public static final List<EventListener> listeners = new ArrayList<>();

    protected JDA jda;
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }
    public void addListener(EventListener[] listener) {
        listeners.addAll(Arrays.asList(listener));
    }

}
