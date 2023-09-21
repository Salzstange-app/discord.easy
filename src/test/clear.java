package test;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class clear extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

/*
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase("!clear")) {
            if (args.length < 2) {
                event.getChannel().sendMessage("Bitte gib an, wie viele Nachrichten gelöscht werden sollen.").queue();
                return;
            }

            int numMessages =Integer.parseInt(args[1]);



            event.getChannel().sendMessage(commands.clear.clear_amount(numMessages, event.getChannel().asTextChannel())).complete().delete().queueAfter(5L, TimeUnit.SECONDS);


        }

 */
    }


}
