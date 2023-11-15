package net.sta.event.level;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sta.event.events.XpManager;

import java.util.Objects;
@SuppressWarnings("unused")
public class VoiceLevel extends ListenerAdapter implements net.sta.event.level.Manager.VoiceLevel, XpManager {
    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        if (Objects.requireNonNull(event.getMember().getVoiceState()).inAudioChannel()) {
            if (canGetVoiceXp(event.getMember())) {
                setVoicePlayerTime(event.getMember(), 1);
                    randXp(event.getMember(), 10);
            }
        }
    }
}
