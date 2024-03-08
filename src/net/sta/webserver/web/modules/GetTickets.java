package net.sta.webserver.web.modules;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.internal.entities.ReceivedMessage;

import java.util.List;

import static net.sta.managers.BotManager.jda;

public class GetTickets {


    public static Integer TicketAmount = 0;
    static Guild guild = jda.getGuilds().get(0);


    public static List<TextChannel> getTicket(String TicketCategoryName){
        List<TextChannel> TextChannel = guild.getCategoriesByName(TicketCategoryName,true).get(0).getTextChannels();
        TicketAmount = TextChannel.size();


      //  System.out.println(TextChannel.get(0).getHistory().retrievePast(50).complete());

    return TextChannel;
    }


}

