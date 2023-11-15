package net.sta.event;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.w3c.dom.events.EventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InterfacedEventManager implements EventManager{

    private final CopyOnWriteArrayList<net.sta.event.listener.EventListener> listeners = new CopyOnWriteArrayList<>();

    public InterfacedEventManager() {}

    @Override
    public void register(Object listener)
    {
        if (!(listener instanceof net.sta.event.listener.EventListener))
        {
            throw new IllegalArgumentException("Listener must implement EventListener");
        }
        listeners.add((net.sta.event.listener.EventListener) listener);
    }

    @Override
    public void unregister(Object listener)
    {
        if (!(listener instanceof EventListener))
        {
            //noinspection ConstantConditions
            JDALogger.getLog(getClass()).warn(
                    "Trying to remove a listener that does not implement EventListener: {}",
                    listener == null ? "null" : listener.getClass().getName());
        }

        //noinspection SuspiciousMethodCalls
        listeners.remove(listener);
    }

    @Override
    public List<Object> getRegisteredListeners()
    {
        return Collections.unmodifiableList(new ArrayList<>(listeners));
    }

    @Override
    public void handle(GenericEvent event)
    {
        for (net.sta.event.listener.EventListener listener : listeners)
        {
            try
            {
                listener.onEvent(event);
            }
            catch (Throwable throwable)
            {
                JDAImpl.LOG.error("One of the EventListeners had an uncaught exception", throwable);
                if (throwable instanceof Error)
                    throw (Error) throwable;
            }
        }
    }

}
