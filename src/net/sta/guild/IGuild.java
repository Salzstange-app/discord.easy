package net.sta.guild;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

public class IGuild implements Guilds{


    public IGuild(JDA api) {
    }

    @Override
    public Guild getGuild(){
        return IGuildHandler.getGuild();
    }

    @Override
    public IGuild getGuildById() {
        return null;
    }



}
