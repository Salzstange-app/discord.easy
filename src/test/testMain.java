package test;

import net.sta.Anotation.Guild;
import net.sta.Prefix;
import net.sta.event.EventPublisher;
import net.sta.webserver.Webserver;
import test.jdatest.bew;
import net.sta.managers.BotManager;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;


public class test extends EventPublisher {

  
	public static Boolean on_of = false;
    @Guild("1037829795725197383")
    public static void main(String[] args) throws LoginException, InterruptedException {
    
        BotManager b = new BotManager("MTA1NjM0NDA5OTM2OTc4NzQ3Mw.GwPFbg.AFTT4X0GDALz74dUfnotQVFn8YJwQltRDZSWTE", Activity.watching("to the Moon"), OnlineStatus.ONLINE);
        Object[] events = {
            new test2(),
            new test0(),
            new bew(),
            new test(),
        };
        b.setPrefix("!");
        b.addEventListener(new bew());
       

        System.out.println(Prefix.getPrefix());
        Webserver webserver = new Webserver(BotManager.jda);
    }
}