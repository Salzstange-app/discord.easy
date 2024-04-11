package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.managers.XpManager;

import java.util.ArrayList;
import java.util.List;
public class VoiceLevel extends ListenerAdapter implements net.sta.event.level.Manager.VoiceLevel, XpManager {
    List<Member> memberList = new ArrayList<>();



    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        if (event.getChannelJoined() != null){
            memberList.add(event.getMember());
            if (canGetVoiceXp(event.getMember())){
                setVoicePlayerTime(event.getMember(), 1);
            }
        }
        else if (event.getChannelLeft() != null) {
            Member memberleft = event.getMember();
            for (Member member : memberList){
                if (member.getId().contains(memberleft.getId())){
                    setVoicePlayerTime(member, 0);
                    playerVoiceTimer.remove(member);
                    memberList.remove(memberleft);
                    break;
                }
            }

        }
    }
}
