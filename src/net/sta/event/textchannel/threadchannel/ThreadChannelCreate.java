package net.sta.event.textchannel.threadchannel;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel;

public class ThreadChannelCreate extends ListenerAdapter {



	@Getter String name = "";
	@Getter @Setter Boolean aBoolean;
	@Getter ThreadChannel threadChannel;
	public ThreadChannelCreate(Guild Guild, String CategoryID) {
		super(Guild, CategoryID);
	}

	public void CreateThreadChannel(String name){

		assert getTextChannel() != null;
		if (aBoolean != null){
			threadChannel =	getTextChannel().getManager().getChannel().createThreadChannel(name, aBoolean).complete();
		}else {
			threadChannel = getTextChannel().getManager().getChannel().createThreadChannel(name).complete();

			//wie kann ich mein eigenen exceptions erstellen und meine eigenen @dinger da habe vergessen wie die heißen lol
			//und was bringen diese komischen @dinger?
		}
	}
	
	
}
