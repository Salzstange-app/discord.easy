package net.sta.event.listener;

import net.dv8tion.jda.api.entities.Member;

public interface Message {
    String getMessage();
    Member getMember();
}
