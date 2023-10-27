package net.sta.event.level;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Objects;
@SuppressWarnings("unused")
public class VoiceLevelManager extends ListenerAdapter implements VoiceLevel, Xp{
    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        if (Objects.requireNonNull(event.getMember().getVoiceState()).inAudioChannel()) {
            if (canGetVoiceXp(event.getMember())) {
                    randXp(event.getMember(), 10);
            }
        }
    }
}
