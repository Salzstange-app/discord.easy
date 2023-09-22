package net.sta.guild;

import lombok.AccessLevel;
import lombok.Setter;
import net.sta.managers.BotManager;
import net.dv8tion.jda.api.entities.Guild;

public class IGuildHandler {
	
	private static Guild guild;
	@Setter(AccessLevel.PROTECTED) private static String guildId;
	public IGuildHandler() {
		
	}
	public static Guild getGuild() {
		return BotManager.jda.getGuildById(guildId);
	}
	
	public static Guild getGuildById(String GuildId) {
		return BotManager.jda.getGuildById(GuildId);
	}
}
