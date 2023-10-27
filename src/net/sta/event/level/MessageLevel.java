package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import java.util.HashMap;
import static net.sta.event.level.MessageLevelManager.playerXp;

public interface MessageLevel {
    HashMap<Member, Integer> playerMessageTimer = new HashMap<>();

    default int getPlayerXp(Member member){
        return playerXp.get(member);
    }
    default void setMessagePlayerTime(Member member, int num){
        playerMessageTimer.put(member, num);
    }
    default int getMessagePlayerTime(Member member){
        return playerMessageTimer.get(member);
    }
    default Boolean canGetXp(Member member){
        return !playerMessageTimer.containsKey(member);
    }


}
