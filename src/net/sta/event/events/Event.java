package net.sta.event.events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.sta.guild.Guilds;

import java.util.List;

public class Event implements Guilds {

    public JDA api;

    public Event(JDA jda){this.api=jda;}
    public JDA getJDA() {
        return api;
    }
    @Override
    public Guild getGuild() {
        return getJDA().getGuilds().get(0);
    }

    @Override
    public Guild getGuildById(String id) {
        return getJDA().getGuildById(id);
    }

    @Override
    public Guild getGuildById(Long id) {
        return getJDA().getGuildById(id);
    }

    @Override
    public List<Guild> getGuilds() {
        return getJDA().getGuilds();
    }
}
