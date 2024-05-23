package net.sta.event.special;

import lombok.Setter;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.sta.managers.GiveawayTimeManager;

import static net.sta.managers.BotManager.jda;

public class Giveaway extends GiveawayTimeManager {

    MessageEmbed Embed;
    String textchannelId;
    TextChannel textchannel;
    @Setter() String timeString = "";


    public Giveaway(TextChannel textChannel){
        this.textchannel = textChannel;
    }

    public Giveaway(String textChannelId){
        this.textchannelId = textChannelId;
    }


    public void Start(){
        startTimer(timeString);
        String msgId = "";
        if (textchannel != null){
            msgId = textchannel.sendMessageEmbeds(Embed).addActionRow(Buttons()).complete().getId();
        } else if (textchannelId != null) {
            msgId = jda.getTextChannelById(textchannelId).sendMessageEmbeds(Embed).setActionRow(Buttons()).complete().getId();
        }
    }

    private Button Buttons(){
        return Button.success("button-success", "Enter the giveaway");
    }
}