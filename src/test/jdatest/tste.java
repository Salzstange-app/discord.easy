package test.jdatest;

import net.sta.event.level.LevelManager;
import net.sta.event.listener.EventAdapter;
import net.sta.event.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;


public class tste extends EventAdapter {

    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {

        if (event.equals("test")){
           int test =  LevelManager.getPlayerXP(event.getMessage().getMember());
            System.out.println(test);
            event.sendMessage("du hast " + test + " xp");
        }


    }
}
