package events.message;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.sta.Botmanager.Prefix;

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
	 * @param prefix Der Prefix-String, mit dem der Nachrichteninhalt verglichen
	 *               wird.
	 * @return True, wenn der Nachrichteninhalt mit dem angegebenen Prefix beginnt
	 *         und das Prefix aktiv ist, ansonsten False.
	 */
	public boolean startsWith(String String) {
		// Überprüfen, ob das Prefix aktiv ist und der Nachrichteninhalt mit dem Prefix
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
