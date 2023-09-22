package test.jdatest;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.events.Event;
import net.sta.events.listener.EventAdapter;
import org.jetbrains.annotations.NotNull;

public class bew extends EventAdapter {

	@Override
	public void onMessageReceivedEvent(@NotNull Event event){
		event.getJDA().getGuildById("1037829795725197383").getTextChannelById("1154379016392945766").sendMessage("tetet").queue();
	}

	/*



	@Override
	public void onMessageReceived(@NotNull MessageReceivedEvent event){
		//blon <3 Ideen was ich jetzt noch machen könnte?
		if (event.getMessage().getContentRaw().startsWith("fff")) {

			TextChannel t3 = new TextChannelCreate(event.getGuild(), "1115001813410775122")
					//.setPermissions(Permission.VIEW_CHANNEL, false, event.getMember())
					//.setPermissions(Permission.MANAGE_CHANNEL, false, event.getMember())
					.toCreate();

			for(Guild guild : event.getJDA().getGuilds()) {
				//System.out.println(net.sta.guild.getId());
			}
			EmbedBuilder builder = new EmbedBuilder();
			builder.setTitle("Title");
			builder.setDescription("Description");
			builder.setFooter("Footer");
			builder.setImage("https://cdn.discordapp.com/attachments/1083080194270703747/1149337694204330035/image.png").setImage("https://cdn.discordapp.com/attachments/987834282431098880/1143993531300597891/image.png");
			
			new MessageHandler(event.getChannel().asTextChannel()).sendEmbeds(builder.build());

		}
		if (new MessageHandler(event.getChannel().asTextChannel()).startsWith("test")) {

			Clear clear = new Clear();

			new MessageHandler(event.getChannel().asTextChannel()).sendMessage(Clear.purgeMessages(101, event.getChannel().asTextChannel())).sendMessage("lel");
			
		}
		
		

		MessageManager m = new MessageManager();
		/*
		 * Thread thread = new Thread(m); thread.run(); // Thread starten
		 */
	/*

		MessageHandler handler = new MessageHandler(event.getChannel().asTextChannel());
		if (handler.startsWith("hallo")) {
			System.out.println("oke");
			// System.out.println(manager.retrieveMessagesFromChannels(event2.getChannel().asTextChannel()));
			event.getChannel().sendMessage("WW").queue();
		}
		if (new MessageHandler(event.getChannel().asTextChannel()).startsWith("2")) {
			// System.out.println(manager.retrieveMessagesFromChannels(event2.getChannel().asTextChannel()));
			event.getChannel().sendMessage("ref e").queue();

		}

	}

	 */
}
