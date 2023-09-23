package net.sta.event.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class not_Updated_MessageSender extends MessageReceivedEvent{
	 private final Message message;
	
	
	public not_Updated_MessageSender(JDA api, long responseNumber, Message message) {
		super(api, responseNumber, message);
		this.message = message;
	}
	
	@Override
	public Message getMessage()
	   {
	        return message;
	   }
	
	/*

    protected String msgid= "";

    protected String msg = "";

    protected String embedid= "";


    protected Message message;
 


    public void sendMessages(String msg, String textchannelid){
   
        if (textchannelid != null){
         //   message = net.sta.guild.getTextChannelById(textchannelid).sendMessage(msg).complete();
        }else {
            // message = getMessage().getChannel().sendMessage(msg).complete();
        }
     this.msgid = message.getId();
     this.msg = message.getContentRaw();
    }

    public void sendMessageEmbed(String textchannelid, MessageEmbed... embed){
        if (textchannelid != null){
       //     message = net.sta.guild.getTextChannelById(textchannelid).sendMessageEmbeds(Arrays.asList(embed)).complete();
       //     net.sta.guild.getTextChannelById(textchannelid).sendMessageEmbeds(Arrays.asList(embed));
        }else {
          //  message = getMessage().getChannel().sendMessageEmbeds(Arrays.asList(embed)).complete();
        }
        this.embedid = message.getId();
    }

*/
}
