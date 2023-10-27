package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class LevelManager implements MessageLevel, VoiceLevel, Xp {

    public static HashMap<Member, Integer> playerXP = new HashMap<>();
    private final Boolean bool;
    public LevelManager(Boolean voice){
        this.bool = voice;
    }

    public void XpTimer(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                try {


                    for (Member member : playerMessageTimer.keySet()) {
                        if (bool) {
                            setMessagePlayerTime(member, getMessagePlayerTime(member) - 1);
                            if (getMessagePlayerTime(member) == 0) {
                                playerMessageTimer.remove(member);
                            }
                            setVoicePlayerTime(member, getVoicePlayerTime(member) - 1);
                            if (getVoicePlayerTime(member) == 0) {
                                playerVoiceTimer.remove(member);
                            }
                        } else {
                            setMessagePlayerTime(member, getMessagePlayerTime(member) - 1);
                            if (getMessagePlayerTime(member) == 0) {
                                playerMessageTimer.remove(member);
                            }
                        }
                    }
                }catch (ConcurrentModificationException ignored){

                }
            }
        };
        new Timer().schedule(timerTask, 1000, 1000);
    }
}
