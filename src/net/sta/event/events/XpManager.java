package net.sta.event.events;

import net.dv8tion.jda.api.entities.Member;

import java.util.Random;

import static net.sta.event.level.LevelManager.playerXP;

public interface XpManager {
    default void randXp(Member member, Integer xP){
        System.out.println("work1");
        if (!playerXP.containsKey(member)) {
            System.out.println("ra");
            playerXP.put(member, 1);
        }else {
            System.out.println("te");
            int xe = new Random().nextInt(1, xP);
            System.out.println(xe);
            playerXP.put(member, playerXP.get(member) + xe);
        }
    }

}
