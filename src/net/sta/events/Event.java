package net.sta.events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import java.util.List;

public class Event {

    public JDA api;

    public Event(JDA jda){this.api=jda;}
    public JDA getJDA() {
        System.out.println(api);
        return api;
    }
    public List<Guild> getGuilds(){
        return api.getGuilds();
    }
    public Guild getGuildById(String id){
        return api.getGuildById(id);
    }
    public Guild getGuildById(Long id){
        return api.getGuildById(id);
    }
}
