package net.sta.event.message;

import net.dv8tion.jda.api.entities.Member;

public interface IMessage {
    String getMessage();
    Member getMember();
}
