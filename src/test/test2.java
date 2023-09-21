package test;
//import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
//import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class test2 extends ListenerAdapter {
/*

    public void onMessageReceived(@NotNull MessageReceivedEvent event1) {
        if (new events.message.MessageReceivedEvent().startsWith("hello")){
            System.out.println("lel");

            MessageSende messageSend = new MessageSende();


            EmbedBuilder builder = new EmbedBuilder();

            ;

     //       Eventbuilder.sendMessageEmbed(builder.build()).setActionRow((ActionRow) Button.success("saf", "afs"), (ActionRow) Button.danger("sfw", "ff"));

            builder.setTitle("22");
            builder.setDescription("@safasf");
            event1.getChannel().sendMessageEmbeds(builder.build()).setActionRow(Button.success("asdasd", "dwd"), Button.danger("asfasf", "assaf")).queue();
        }
    }


 */

/*
    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {

        if (event.getChannelJoined().getIdLong() == 1057782997484568676L) {
            TempChannel t  = new TempChannel("1057782929012564008", "1057786554904490137",  event.getGuild(), event.getMember());
            t.setTcName("Settings " + event.getMember().getEffectiveName());
            t.setVcName("VoiceChannel " + event.getMember().getEffectiveName());

            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("stet");
            builder.setDescription("2sgdg");

            t.setTextChannelPermission(Permission.VIEW_CHANNEL, false, null, event.getGuild().getPublicRole());
            t.setVoiceChannelPermission(Permission.MANAGE_PERMISSIONS, false, null, event.getGuild().getPublicRole());


            ActionRow s = ActionRow.of(
                    Button.success("sgsg", "sf")
            );
            t.startTempVoice(builder, s);


        }
    }

    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {

        if(event.getChannelJoined().getIdLong() == 1057782997484568676L) {
            TempChannel t  = new TempChannel("1057782929012564008", "1057786554904490137",  event.getGuild(), event.getMember());
            t.setTcName("Settings " + event.getMember().getEffectiveName());
            t.setVcName("VoiceChannel " + event.getMember().getEffectiveName());

            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("stet");
            builder.setDescription("2sgdg");

            t.setTextChannelPermission(Permission.VIEW_CHANNEL, false, null, event.getGuild().getPublicRole());
            t.setVoiceChannelPermission(Permission.MANAGE_ROLES, false, event.getMember(), null);
            ActionRow s = ActionRow.of(
                    Button.success("sgsg", "sf")
            );
            t.startTempVoice(builder, s);
        }
        else {
            TempChannel.deleteTempVoice(event.getChannelLeft());
        }
    }


    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        try {
            TempChannel.deleteTempVoice(event.getChannelLeft());
        }catch (NoSuchElementException e){
        }
    }


 */
}
