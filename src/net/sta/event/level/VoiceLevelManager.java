package net.sta.event.level;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Objects;
import static net.sta.event.level.MessageLevelManager.playerXp;
@SuppressWarnings("unused")
public class VoiceLevelManager extends ListenerAdapter implements VoiceLevel, Xp{
    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        if (Objects.requireNonNull(event.getMember().getVoiceState()).inAudioChannel()) {
            if (canGetXp(event.getMember())) {
                    randXp(event.getMember(), 10, playerXp.get(event.getMember()));
            }
        }
    }
}