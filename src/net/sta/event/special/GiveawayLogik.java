package net.sta.event.special;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GiveawayLogik extends ListenerAdapter {

    static ArrayList<Member> allEnteredMember = new ArrayList<>();
    static Member lastWinner = null;
    Map<Member, Integer> MemberWinnerList = new HashMap<>();


    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getInteraction().equals("button-success")){

            if (allEnteredMember.equals(event.getMember())){
                allEnteredMember.remove(event.getMember());
            }else {
                allEnteredMember.add(event.getMember());
            }
            System.out.println(event.getMember());
        }
    }

    protected static Member getWinner(){
        Member randomMember = allEnteredMember.get(new Random().nextInt(allEnteredMember.size()));

        if (lastWinner == null){
            lastWinner = randomMember;
            return randomMember;
        }

        else {
            if (randomMember == lastWinner){
                boolean lastWinnerWinChance = Math.random() < 0.15;
                if (lastWinnerWinChance){
                    lastWinner = randomMember;
                    return lastWinner;
                }else {
                    lastWinner = randomMember;
                    return randomMember;
                }
            }else {
                lastWinner = randomMember;
                return  lastWinner;
            }
        }
    }
}
