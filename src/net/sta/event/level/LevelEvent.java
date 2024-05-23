package net.sta.event.level;

import net.sta.managers.LevelManager;

@SuppressWarnings("unused")
public class LevelEvent extends LevelManager {
    Boolean bool;
    public LevelEvent(Boolean Voice){
        this.bool = Voice;
    }
   public void startLevel(){
        LevelManager manager = new LevelManager();
        manager.XpTimer();
        if (bool)
            manager.VoiceXpTimer();
   }
}
