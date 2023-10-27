package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class LevelManager implements MessageLevel, VoiceLevel, Xp{

    static HashMap<Member, Integer> playerXP = new HashMap<>();
    private final Boolean bool;
    public LevelManager(Boolean voice){
        this.bool = voice;
    }

    public void XpTimer(){
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

    @Override
    public int getPlayerXp(Member member) {
        return MessageLevel.super.getPlayerXp(member);
    }

    @Override
    public void setMessagePlayerTime(Member member, int num) {
        MessageLevel.super.setMessagePlayerTime(member, num);
    }

    @Override
    public int getMessagePlayerTime(Member member) {
        return MessageLevel.super.getMessagePlayerTime(member);
    }

    @Override
    public void setVoicePlayerTime(Member member, int num) {
        VoiceLevel.super.setVoicePlayerTime(member, num);
    }

    @Override
    public int getVoicePlayerTime(Member member) {
        return VoiceLevel.super.getVoicePlayerTime(member);
    }

    @Override
    public Boolean canGetXp(Member member) {
        return MessageLevel.super.canGetXp(member);
    }

    @Override
    public void randXp(Member member, Integer xP, Integer oldXp) {
        Xp.super.randXp(member, xP, oldXp);
    }
}
