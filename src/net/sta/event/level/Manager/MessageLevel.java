package net.sta.event.level.Manager;

import net.dv8tion.jda.api.entities.Member;
import java.util.HashMap;

public interface MessageLevel {
    HashMap<Member, Integer> playerMessageTimer = new HashMap<>();

    default void setMessagePlayerTime(Member member, int num){
        playerMessageTimer.put(member, num);
    }
    default int getMessagePlayerTime(Member member){
        return playerMessageTimer.get(member);
    }
    default Boolean canGetMessageXp(Member member){
        return !playerMessageTimer.containsKey(member);
    }


}
