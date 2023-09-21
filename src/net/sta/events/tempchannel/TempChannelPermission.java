package net.sta.events.tempchannel;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.EnumSet;
import java.util.Random;

import net.sta.managers.BotManager;

import static net.sta.events.tempchannel.TempChannel.*;

public class TempChannelPermission extends ListenerAdapter {

	private Permission voicePermission;
	private Boolean voiceAllow;
	private Member voicePermMember;
	private Role voicePermRole;

	private Permission textPermission;
	private Boolean textAllow;
	private Member textPermMember;
	private Role textPermRole;

	private String categoryId;
	private String settingCategoryId;

	private TextChannel textChannel;
	private VoiceChannel audioChannel;

	public void setVoicePermission(Permission permission, Boolean allow, Member member, Role role) {
		this.voicePermission = permission;
		this.voiceAllow = allow;
		this.voicePermMember = member;
		this.voicePermRole = role;
	}

	public void setTextChannelPermission(Permission permission, Boolean allow, Member member, Role role) {
		this.textPermission = permission;
		this.textAllow = allow;
		this.textPermMember = member;
		this.textPermRole = role;
	}

	public void setCategoryIds(String CategoryId, String SettingCategoryId) {
		categoryId = CategoryId;
		settingCategoryId = SettingCategoryId;
	}

	public Boolean getVoiceAllow() {
		return voiceAllow;
	}

	public void setVoiceAllow(Boolean voiceAllow) {
		this.voiceAllow = voiceAllow;
	}

	// Getter und Setter für voicePermMember
	public Member getVoicePermMember() {
		return voicePermMember;
	}

	public void setVoicePermMember(Member voicePermMember) {
		this.voicePermMember = voicePermMember;
	}

	// Getter und Setter für voicePermRole
	public Role getVoicePermRole() {
		return voicePermRole;
	}

	public void setVoicePermRole(Role voicePermRole) {
		this.voicePermRole = voicePermRole;
	}

	// Getter und Setter für textPermission
	public Permission getTextPermission() {
		return textPermission;
	}

	public void setTextPermission(Permission textPermission) {
		this.textPermission = textPermission;
	}

	// Getter und Setter für textAllow
	public Boolean getTextAllow() {
		return textAllow;
	}

	public void setTextAllow(Boolean textAllow) {
		this.textAllow = textAllow;
	}

	// Getter und Setter für textPermMember
	public Member getTextPermMember() {
		return textPermMember;
	}

	public void setTextPermMember(Member textPermMember) {
		this.textPermMember = textPermMember;
	}

	// Getter und Setter für textPermRole
	public Role getTextPermRole() {
		return textPermRole;
	}

	public void setTextPermRole(Role textPermRole) {
		this.textPermRole = textPermRole;
	}

	// Getter und Setter für categoryId
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	// Getter und Setter für settingCategoryId
	public String getSettingCategoryId() {
		return settingCategoryId;
	}

	/*
	 * public static void setSettingCategoryId(String settingCategoryId) {
	 * this.settingCategoryId = settingCategoryId; }
	 */
	// Getter und Setter für textChannel
	public TextChannel getTextChannel() {
		return textChannel;
	}

	// Getter und Setter für audioChannel
	public VoiceChannel getAudioChannel() {
		return audioChannel;
	}

	public void setID() {
		TempChannel.setHashmap(textChannel, audioChannel);
	}

	public void setTextChannel() {
		Guild guild = BotManager.jda.getGuilds().get(0);
		System.out.println(guild);

		String channelName = TcName != null ? TcName : "Settings";
		IPermissionHolder holder = textPermMember != null ? textPermMember : textPermRole;

		TextChannel tc = guild.getCategoryById(settingCategoryId).createTextChannel(channelName)
				.addPermissionOverride(holder, EnumSet.of(textPermission), null).complete();

		this.textChannel = tc;
		setID();
	}

	public void setVoiceChannel(Member m) {
		Guild guild = BotManager.jda.getGuilds().get(0);
		System.out.println(guild);

		String channelName = VcName != null ? VcName : "VoiceChannel " + new Random().nextInt(10000);
		IPermissionHolder holder = textPermMember != null ? textPermMember : textPermRole;

		VoiceChannel vc = guild.getCategoryById(categoryId).createVoiceChannel(channelName)
				.addPermissionOverride(holder, EnumSet.of(voicePermission), null).complete();

		guild.moveVoiceMember(m, vc).queue();
		this.audioChannel = vc;
	}
}