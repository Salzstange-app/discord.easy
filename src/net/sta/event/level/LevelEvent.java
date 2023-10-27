package net.sta.event.level;

@SuppressWarnings("unused")
public class LevelEvent  extends LevelManager {
    Boolean bool;
    public LevelEvent(Boolean Voice){
        super(Voice);
        this.bool = Voice;
    }
   public void startLevel(){
        LevelManager manager = new LevelManager(bool);
        manager.XpTimer();
   }
}
