package net.sta.event.message;

import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.Arrays;
@SuppressWarnings("all")

public interface Message{
     default void sendMessage(String message){
         MessageGetter.Message.getChannel().sendMessage(message).queue();
    }
     default void sendEmbed(MessageEmbed... emebeds){
        MessageGetter.Message.getChannel().sendMessageEmbeds(Arrays.asList(emebeds)).queue();
    }
     default void sendMessage(String message, Integer ChannelId){
         MessageGetter.Message.getGuild().getTextChannelById(ChannelId).sendMessage(message).queue();
    }
     default void sendEmbed(Integer ChannelId, MessageEmbed... emebeds){
         MessageGetter.Message.getGuild().getTextChannelById(ChannelId).sendMessageEmbeds(Arrays.asList(emebeds)).queue();
    }

    default Boolean startsWith(String string){
         if (string.startsWith(String.valueOf(MessageGetter.Message.getContentRaw()))) {
             return true;
         }
         return false;
    }
    default Boolean equals(String string){
         if (string.equals(String.valueOf(MessageGetter.Message.getContentRaw()))){
             return true;
         }
        return false;
    }
}
