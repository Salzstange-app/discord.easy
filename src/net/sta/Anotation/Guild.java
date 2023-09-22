package net.sta.Anotation;

import net.sta.guild.IGuildHandler;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Guild {

    //https://openbook.rheinwerk-verlag.de/java8/17_007.html#u17.7
    String value();

}
