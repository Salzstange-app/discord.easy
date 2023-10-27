package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;

import java.util.Random;

import static net.sta.event.level.LevelManager.playerXP;

public interface Xp {
    default void randXp(Member member, Integer xP, Integer oldXp){
        if (!playerXP.containsKey(member))
            playerXP.put(member, 0);
        playerXP.put(member, oldXp + new Random().nextInt(0,xP));
    }

}
