package test.jdatest;

import net.sta.event.listener.EventAdapter;
import net.sta.event.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class msg2 extends EventAdapter {
    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {
        super.onMessageReceivedEvent(event);

        if (event.startsWith("test")){
            event.getMessage().getChannel().sendMessage("test").queue();
        }
    }
}
