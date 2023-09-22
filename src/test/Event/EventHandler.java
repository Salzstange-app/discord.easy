package test.Event;

import net.dv8tion.jda.api.entities.Member;

public class EventHandler extends DiscordAdapter{


    @Override
    public void textChannelCreateEvent(DiscordEvent event) {
        Member m = event.getGuild().getMembers().get(0);
        System.out.println(m);
    }

    public static void main(String[] args) {

    }
}
