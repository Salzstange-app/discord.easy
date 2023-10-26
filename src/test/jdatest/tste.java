package test.jdatest;

import net.sta.event.listener.EventAdapter;
import net.sta.event.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class tste extends EventAdapter {

    @Override
    public void onMessageReceivedEvent(@NotNull MessageReceivedEvent event) {


        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URL("http://localhost:9595/callback").openConnection();













        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (event.equals("test")){

        }


    }
}
