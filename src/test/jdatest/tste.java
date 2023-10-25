package test.jdatest;

import net.dv8tion.jda.api.EmbedBuilder;
import net.sta.event.listener.EventAdapter;
import net.sta.event.message.MessageReceivedEvent;
import net.sta.event.special.Giveaway;
import org.jetbrains.annotations.NotNull;
import spark.embeddedserver.jetty.EmbeddedJettyFactory;

public class tste extends EventAdapter {

    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {


        if (event.equals("test")){

        }


    }
}
