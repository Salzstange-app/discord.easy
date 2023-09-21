package net.sta.events.message;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class MessageManager extends MessageListManager {

	//private final static int NUM_MESSAGES_TO_RETRIEVE = 1; // Anzahl der abzurufenden Nachrichten

	/*
	 * Ist noch nicht Fertig vlt update ich das ganze noch
	 * 
	 * @Override public void run() { jda.getTextChannels().forEach(channel ->
	 * {channel.getHistory().retrievePast(NUM_MESSAGES_TO_RETRIEVE).complete().
	 * forEach(messages -> {System.out.println(messages);});}); }
	 */
	private static void collectLastMessage(TextChannel textChannel) {
		addToMessageList(textChannel,textChannel.getLatestMessageId());
		// textChannel.getHistory().retrievePast(NUM_MESSAGES_TO_RETRIEVE).complete().forEach(msg
		// -> {System.out.println(msg);});
		// fragt nach der ersten Nachricht aus dem textChannel
		/*
		for (Message messageContent : textChannel.getHistory().retrievePast(NUM_MESSAGES_TO_RETRIEVE).complete()) {
			// bringt den textChannel und die messageId in eine liste
			addToMessageList(textChannel, messageContent.getId());
		}
		*/
	}

	/**
	 * Ruft eine Nachricht aus einem Textkanal ab, die in der Nachrichtenliste
	 * gespeichert ist. Zuerst werden Nachrichten aus den Kanälen gesammelt und dann
	 * die gewünschte Nachricht abgerufen.
	 *
	 * @param textChannel Der Textkanal, aus dem die Nachricht abgerufen werden
	 *                    soll.
	 * @return Die abgerufene Nachricht aus dem angegebenen Textkanal.
	 */
	public static Message getLastMessage(TextChannel textChannel) {
		// Zuerst werden Nachrichten aus den Kanälen gesammelt
		collectLastMessage(textChannel);

		// Die Nachrichten-ID aus der Liste abrufen und die Nachricht abrufen
		String messageID = getMessageFromList(textChannel);
		messageList.remove(textChannel.getId());
		return textChannel.retrieveMessageById(messageID).complete();
	}
}
