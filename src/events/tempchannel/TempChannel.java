package events.tempchannel;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;

import java.util.*;

public class TempChannel extends ListenerAdapter {

    public static String categoryId;
    public static String VcName;
    public static String TcName;
    
    private static Guild guild;
    
    public String settingid;
    private Member member;

    TempChannelPermission tempChannelPermission = new TempChannelPermission();

    private static HashMap<TextChannel, AudioChannel> id = new HashMap<>();

    public TempChannel(String CategoryId, String SettingCategory, Guild Guild, Member member){
        categoryId = CategoryId;
        guild = Guild;
        this.settingid = SettingCategory;
        this.member = member;
    }

    static void setHashmap(TextChannel tc, AudioChannel audioChannel){
        id.put(tc, audioChannel);
        System.out.println(tc + " f " + audioChannel);
    }
    public void setVcName(String VoiceChannelName) {
        VcName = VoiceChannelName;
    }

    public void setTcName(String TextChannelName){
        TcName = TextChannelName;
    }

    public void startTempVoice(EmbedBuilder EmbedBuilder, ActionRow actionRow){
        createVoiceJoin();
        if (actionRow == null){
          // guild.getTextChannelById(TempChannelPermission.getTextChannelId())).sendMessageEmbeds(EmbedBuilder.build()).queue();
        }else {
         //   guild.getTextChannelById(TempChannelPermission.getTextCahnnelid()).sendMessageEmbeds(EmbedBuilder.build()).setActionRow((Collection<? extends ItemComponent>) actionRow).queue();
        }if (actionRow == null && EmbedBuilder == null){
            return;
        }
    }

    public void setVoiceChannelPermission(Permission permission , Boolean allow, Member member, Role role){
        tempChannelPermission.setVoicePermission(permission, allow, member, role);
    }
    public void setTextChannelPermission(Permission permission , Boolean allow, Member member, Role role){
        tempChannelPermission.setTextChannelPermission(permission, allow, member, role);
    }

    protected void createVoiceJoin() {

        try {
            tempChannelPermission.setVoiceChannel(member);
            tempChannelPermission.setTextChannel();
        } catch (NullPointerException e) {

            e.printStackTrace();
            throw new NullPointerException("Error! Please Check that you place the Permission on the right place!!");
        }
        System.out.println(id.size());
    }

    public static String getVcName(){
        return VcName;
    }

    public static void deleteTempVoice(AudioChannel audioChannel){

        System.out.println(id.keySet().iterator().next().getId());
        String i = id.keySet().iterator().next().getId();
        TextChannel t = guild.getTextChannelById(i);

        AudioChannel AudioChannel = id.get(t);

        ArrayList<String> args = new ArrayList<>(Arrays.asList(getVcName().split(" ")));
        String name = args.get(0);
        args.remove(0);


        if (AudioChannel.getMembers().isEmpty() && audioChannel.getName().startsWith(name)) {
            audioChannel.delete().queue();

            guild.getTextChannelById(t.getId()).delete().queue();
            id.remove(t);

        }
    }
}
