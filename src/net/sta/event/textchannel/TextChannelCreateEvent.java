package net.sta.event.textchannel;

import net.dv8tion.jda.api.entities.Guild;

public class TextChannelCreateEvent  extends PermissionChannelManager{


    public TextChannelCreateEvent(Guild guild, String categoryId) {
        super(guild, categoryId);
    }
}
