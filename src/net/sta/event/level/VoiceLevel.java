package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.event.events.XpManager;

import java.util.ArrayList;
import java.util.List;
public class VoiceLevel extends ListenerAdapter implements net.sta.event.level.Manager.VoiceLevel, XpManager {




    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        List<Member> memberList = new ArrayList<>();
        if (event.getChannelJoined() != null){
            System.out.println("joined");
            memberList.add(event.getMember());
           // if (canGetVoiceXp(event.getMember())){
                setVoicePlayerTime(event.getMember(), 1);
                randXp(event.getMember(), 10);
            System.out.println("xp ");
            //}
        }
        else if (event.getChannelLeft() == null) {
            Member memberleft = event.getMember();
            for (Member member : memberList){
                if (member.getId().contains(memberleft.getId())){
                    System.out.println("leave");
                    break;
                }else {
                    memberList.remove(memberleft);
                }
            }

        }/*
        System.out.println("test");
        System.out.println(event.getChannelJoined().getMembers());
        if (Objects.requireNonNull(event.getMember().getVoiceState()).inAudioChannel()) {
            if (canGetVoiceXp(event.getMember())) {
                setVoicePlayerTime(event.getMember(), 1);
                    randXp(event.getMember(), 10);
            }
        }
        */
    }
}
