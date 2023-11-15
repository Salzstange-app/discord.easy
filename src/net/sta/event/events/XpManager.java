package net.sta.event.events;

import net.dv8tion.jda.api.entities.Member;

import java.util.Random;

import static net.sta.event.level.LevelManager.playerXP;

public interface XpManager {
    default void randXp(Member member, Integer xP){
        if (!playerXP.containsKey(member)) {
            playerXP.put(member, 1);
        }else {
            int xe = new Random().nextInt(1, xP);
            playerXP.put(member, playerXP.get(member) + xe);
        }
    }

}
