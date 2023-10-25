package net.sta.event.special;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GiveawayLogik extends ListenerAdapter {

    ArrayList<Member> allMember = new ArrayList<>();
    Map<Member, Integer> MemberWinnerList = new HashMap<>();
    protected Member getWinner(){
        return allMember.get(new Random().nextInt(0, MemberWinnerList.size()));
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getInteraction().equals("button-success")){
            if (MemberWinnerList.equals(event.getMember())){
                MemberWinnerList.remove(event.getMember());
                allMember.remove(event.getMember());
            }else {
                MemberWinnerList.put(event.getMember(), 0);
                allMember.add(event.getMember());
            }
            System.out.println(event.getMember());
        }
        if (getWinner() != null){
            event.getButton().asDisabled();
        }
    }
}
