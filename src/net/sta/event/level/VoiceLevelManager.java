package net.sta.event.level;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.time.Instant;
import java.util.HashMap;

public class VoiceLevelManager extends ListenerAdapter implements VoiceLevel{

    private static HashMap<Member, Long> playerVoiceTime = new HashMap<>();

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        if (canGetXp(event.getMember())) {
            if (event.getChannelJoined() != null) {
                playerVoiceTime.put(event.getMember(), Instant.now().getEpochSecond());
            } else {
                Long i = playerVoiceTime.get(event.getMember()) - Instant.now().getEpochSecond();
                playerVoiceTime.put(event.getMember(), i);
            }
        }
    }
}
