package test;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.event.listener.EventAdapter;
import net.sta.managers.BotManager;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.sta.managers.BotManager.jda;

public class teste extends EventAdapter {

    public static void tes() {

        Member lastwinner = null;

        List<Member> members2 = new ArrayList<>();
        jda.getGuildById("1037829795725197383").getMembers().forEach(Member -> members2.add(Member));



        for (int i = 0; i < 10; i++) {

        }



    }




}
