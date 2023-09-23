package net.sta.guild;

import net.dv8tion.jda.api.entities.Guild;

import java.util.List;

public interface Guilds {

     Guild getGuild();
     Guild getGuildById(String id);
     Guild getGuildById(Long id);
     List<Guild> getGuilds();
}
