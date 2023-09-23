package net.sta.event.textchannel;

import java.util.ArrayList;
import lombok.Getter;;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class TextChannelListObject {
	
	public static ArrayList<TextChannelListObject> textChannelList = new ArrayList<>();
	
	
	@Getter private Permission permission;
	@Getter private final IPermissionHolder ipermisionholder;
	@Getter private final Boolean isAllowed;
	@Getter private Role role;
	@Getter private Member member;
	
	public TextChannelListObject(Permission permission, IPermissionHolder Ipmerissionholder, Boolean isAllow){
		this.permission = permission;
		this.ipermisionholder = Ipmerissionholder;

		
		isAllowed = isAllow;
	}
}
