package commands;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {

    public static String purgeMessages(int amount, TextChannel textChannel) {

		try {
			for(int i = 0; i < amount / 100; i++) {
				textChannel.deleteMessages(textChannel.getHistory().retrievePast(100).complete()).queue();
			}

			textChannel.deleteMessages(textChannel.getHistory().retrievePast(amount % 100).complete()).queue();

			return amount + " messages got successfully deleted";
		}catch (IllegalArgumentException exception){

		}
    	return " ";

    }

}
