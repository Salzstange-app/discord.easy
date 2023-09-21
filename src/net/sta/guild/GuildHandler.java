package net.sta.guild;

import net.sta.managers.BotManager;
import net.dv8tion.jda.api.entities.Guild;

public class GuildHandler{
	
	private Guild guild;
	public GuildHandler() {
		
	}
	public Guild getGuild() {
		//assert net.sta.guild != null;

		return BotManager.jda.getGuilds().get(0);
	}
	
	public Guild getGuildById(String GuildId) {
		assert guild != null;
		return this.guild = BotManager.jda.getGuildById(GuildId);
	}
}
