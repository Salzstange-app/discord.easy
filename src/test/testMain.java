package test;

import net.sta.Anotation.Guild;
import net.sta.commands.levelCommand;
import net.sta.event.level.LevelEvent;
import net.sta.event.listener.EventAdapter;
import net.sta.managers.BotManager;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.sta.webserver.Webserver;



import javax.security.auth.login.LoginException;

@Guild("1037829795725197383")

public class testMain extends EventAdapter {


    public static Boolean on_of = false;
    public static void main(String[] args) throws LoginException, InterruptedException {

        BotManager b = new BotManager("MTA1NjM0NDA5OTM2OTc4NzQ3Mw.Gqsizv.UblQhgzoaFoMvI2lmkjo9gPZ4eQGi7ykZ6Yx8Q", Activity.watching("to the Moon"), OnlineStatus.ONLINE);
        Object[] events = {
                new testMain(),
                new levelCommand()
        };

        teste.tes();
        //b.addListener(new levelCommand());
       // b.setEvents(new levelCommand());


        //  b.setEvents(new levelCommand());
        //( b.setEvents(new MessageLevel());

        Webserver webserver = new Webserver(BotManager.jda);
        // b.addListener(new L);
        b.setPrefix("!");

        LevelEvent levelEvent = new LevelEvent(true);
        levelEvent.startLevel();



        /*
        System.out.println(Prefix.getPrefix());
        Webserver webserver = new Webserver(BotManager.jda);

*/
        /*
        Guild ab= testMain.class.getAnnotation(Guild.class);
        if (ab != null) {
            System.out.print(ab.value() + "; ");
        }

         */


        // System.out.println(testMain.class.getAnnotation(Guild.class).value());








    }
}
