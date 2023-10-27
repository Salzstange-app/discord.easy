package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import java.util.HashMap;
public interface VoiceLevel {
    HashMap<Member, Integer> playerVoiceTimer = new HashMap<>();
    default void setVoicePlayerTime(Member member, int num){
        playerVoiceTimer.put(member, num);
    }
    default int getVoicePlayerTime(Member member){
        return playerVoiceTimer.get(member);
    }
    default Boolean canGetVoiceXp(Member member){
        return !playerVoiceTimer.containsKey(member);
    }
}
