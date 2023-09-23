package net.sta.event.textchannel;

import net.dv8tion.jda.api.entities.Guild;
public class TextChannelCreate extends PermissionChannelManager {

	public TextChannelCreate(Guild Guild, String CategoryID) {
		super(Guild, CategoryID);
	}
}

