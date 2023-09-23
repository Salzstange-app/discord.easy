package net.sta.event.message;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import java.util.HashMap;
import java.util.Map;

public class MessageListManager {

	// Der Code verwendet eine HashMap, um die Nachrichten-IDs zu speichern. Die
	// Schlüssel in der Map sind die IDs der Textkanäle.
	public static Map<String, String> messageList = new HashMap<>();

	/*
	 * Diese Methode wird verwendet, um eine Nachrichten-ID zur Liste hinzuzufügen.
	 * Sie akzeptiert zwei Parameter: ein TextChannel-Objekt, das den Textkanal
	 * repräsentiert, und eine Nachrichten-ID als Zeichenfolge (msgID). Die Methode
	 * überprüft zuerst, ob die Liste der Nachrichten-IDs bereits die angegebene
	 * msgID enthält. Wenn die msgID nicht vorhanden ist, wird ein neuer Eintrag in
	 * der Map erstellt, wobei der Schlüssel die ID des Textkanals ist und der Wert
	 * die msgID ist.
	 */

	protected static void addToMessageList(TextChannel textChannel, String msgID) {
		if (!messageList.values().contains(msgID)) {
			messageList.put(textChannel.getId(), msgID);
		}
	}

	// ruft die Nachrichten-ID für einen gegebenen Textkanal ab.
	protected static String getMessageFromList(TextChannel textChannel) {
		return messageList.get(textChannel.getId());
	}
}
