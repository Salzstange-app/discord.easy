package test.jdatest;

import net.sta.managers.LevelManager;
import net.sta.event.listener.EventAdapter;
import net.sta.event.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;


public class tste extends EventAdapter {

    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {

        System.out.println("test");

        if (event.equals("test")){

            System.out.println("test");
           int test =  LevelManager.getPlayerXP(event.getMessage().getMember());
            System.out.println(test);
            event.sendMessage("du hast " + test + " xp");
        }


    }
}
