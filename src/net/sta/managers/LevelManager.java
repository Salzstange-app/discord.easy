package net.sta.managers;

import net.dv8tion.jda.api.entities.Member;
import net.sta.event.level.Manager.MessageLevel;
import net.sta.event.level.Manager.VoiceLevel;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class LevelManager implements MessageLevel, VoiceLevel, XpManager {

    public static HashMap<Member, Integer> playerXP = new HashMap<>();

    public void XpTimer(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    for (Member member : playerMessageTimer.keySet()) {
                            setMessagePlayerTime(member, getMessagePlayerTime(member) - 1);
                        if (getMessagePlayerTime(member) == 0) {
                                playerMessageTimer.remove(member);
                        }
                    }
                }catch (ConcurrentModificationException | NullPointerException ignored){}
            }
        };
        new Timer().schedule(timerTask, 1000, 1000);
    }

    public void VoiceXpTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                for (Member member : playerVoiceTimer.keySet()) {
                        randXp(member, 10);
                        System.out.println("VoicePlayerTime " + getVoicePlayerTime(member));
                }
            }
            //jede 10 sekunden

        },10000, 10000);
    }
    public static Integer getPlayerXP(Member member) {
        return playerXP.get(member) != null ? playerXP.get(member) : 0;
    }
}
