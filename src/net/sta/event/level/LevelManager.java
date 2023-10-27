package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class LevelManager implements MessageLevel, VoiceLevel, Xp{

    static HashMap<Member, Integer> playerXP = new HashMap<>();
    private Boolean bool;
    public LevelManager(Boolean voice){
        this.bool = voice;
    }








    private void XpTimer(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

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
                        }else {
                            setMessagePlayerTime(member, getMessagePlayerTime(member) - 1);
                            if (getMessagePlayerTime(member) == 0) {
                                playerMessageTimer.remove(member);
                            }
                        }
                    }
            }
        };
        new Timer().schedule(timerTask, 100, 100);
    }
}
