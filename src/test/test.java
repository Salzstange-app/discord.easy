package test;

import net.sta.Botmanager.Prefix;
import test.jdatest.bew;
import webserver.Webserver;
import managers.BotManager;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;


public class test extends ListenerAdapter{

  
	public static Boolean on_of = false;
    public static void main(String[] args) throws LoginException, InterruptedException {
    
        BotManager b = new BotManager("MTA1NjM0NDA5OTM2OTc4NzQ3Mw.GwPFbg.AFTT4X0GDALz74dUfnotQVFn8YJwQltRDZSWTE", Activity.watching("to the Moon"), OnlineStatus.ONLINE);
        Object[] events = {
            new test2(),
            new test0(),
            new clear(),
            new bew(),
            new test(),
        };
        
        
       
        



        b.setPrefix("!");
        b.setEvents(events);
       

        System.out.println(Prefix.getPrefix());
        Webserver webserver = new Webserver(BotManager.jda);
    }
}
