package net.sta.events.message;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.sta.Prefix;
import net.sta.events.Event;
import net.sta.events.listener.EventAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageHandler {
	private Message message;
	private TextChannel textchannel;




	public MessageHandler(TextChannel textChannel) {
		textchannel = textChannel;
		message = MessageManager.getLastMessage(textChannel);
	}

	/**
	 * Überprüft, ob die Nachricht mit einem bestimmten Präfix beginnt.
	 *
	 * @param prefix Der net.sta.Prefix-String, mit dem der Nachrichteninhalt verglichen
	 *               wird.
	 * @return True, wenn der Nachrichteninhalt mit dem angegebenen net.sta.Prefix beginnt
	 *         und das net.sta.Prefix aktiv ist, ansonsten False.
	 */
	public boolean startsWith(String String) {
		// Überprüfen, ob das net.sta.Prefix aktiv ist und der Nachrichteninhalt mit dem net.sta.Prefix
		// beginnt
		
		return Prefix.hasPrefix() && message.getContentRaw().startsWith(Prefix.getPrefix() + String) ? true : false;
	}

	public String getMessage() {
		return message.getContentRaw();
	}
	
	
	public MessageHandler sendMessage(String message) {
		textchannel.sendMessage(message).queue();
		return this;
		
	}
	
	public MessageHandler sendEmbeds(MessageEmbed builder, MessageEmbed... others) {
			textchannel.getGuild().getTextChannelById(textchannel.getIdLong()).sendMessageEmbeds(builder, others).queue();
		return this;
	}
}
