package net.sta.event.textchannel;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;
import java.util.*;

public class PermissionChannelManager {

	@Getter private static List<String> ticketId = new ArrayList<>();
	@Getter private final String categoryId;
	@Getter private TextChannel textChannel;
	@Getter private final Guild guild;
	@Getter @Setter private String textChannelName = "TextChannel";

	public PermissionChannelManager(Guild guild, String categoryId) {		
		this.guild = guild;
		this.categoryId = categoryId;
	}

	public PermissionChannelManager setPermissions(Permission Permission, Boolean Allow, IPermissionHolder holder) {
		TextChannelListObject.textChannelList.add(new TextChannelListObject(Permission, holder, Allow));
		return this;
	}

	ChannelAction<TextChannel> action;
	public TextChannel toCreate() {

		ArrayList<TextChannelListObject> list = TextChannelListObject.textChannelList;
		ArrayList<Permission> allowedPermissions = new ArrayList<>();
		ArrayList<Permission> deniedPermissions = new ArrayList<>();

		if (list.isEmpty()) {
			action = guild.getCategoryById(categoryId).createTextChannel(textChannelName);
		}else {
		assert !list.isEmpty();
		for(TextChannelListObject object : list) {
			if (object.getIsAllowed()) {
				allowedPermissions.add(object.getPermission());
			}else deniedPermissions.add(object.getPermission());

			action.addPermissionOverride(object.getIpermisionholder(), allowedPermissions, deniedPermissions);
			}
			list.remove(0);
			allowedPermissions.clear();
			deniedPermissions.clear();
		}
		// ey dw geh mal in TextchannelCreate kann ich das ned eig zu einem Interface machen ? Hallo lebst du noch?! ne
		textChannel = action.complete();
		ticketId.add(textChannel.getId());
		System.out.println("et");
		return textChannel;
	}
	public static TextChannel getTextChannelById(String TextChannelID, Guild guild) {
		return guild.getTextChannelById(TextChannelID);
	}

	public PermissionChannelManager setName(String TextChannelName) {
		this.textChannelName = TextChannelName;
		return this;
	}

}
