package net.sta.events.IpermissionHolder;

import net.sta.guild.GuildHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class Ipermission {
	
	private IPermissionHolder ipermholder;
	private Member member = null;
	private User user; 
	private Role role = null;
	private Guild guild = new GuildHandler().getGuild();
	
	
	public Ipermission(IPermissionHolder IPermHolder) {
		this.ipermholder = IPermHolder;
		checkInputs();
	}
	
	public IPermissionHolder IpermissionHolder() {
		if(member == null) {
			return role != null ? role : null;
		}else if (role == null){
			return member != null ? member : null;
		}
		return null;	
	}
	
	private void checkInputs() {
		
		if (ipermholder instanceof Member)
			this.member = guild.getMemberById(ipermholder.getId());
		if (ipermholder instanceof Role)
			this.role = guild.getRoleById(ipermholder.getId());		
	}
	
	public Role getAsRole() {
		return role != null ? role : null;
	}
	
	public Member getAsMember() {
		return member != null ? member : null;
	}
	
	public User getAsUser() {
		return user != null ? user : null;
	}
}
