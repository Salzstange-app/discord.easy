package test;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.net.URLEncoder.*;


public class test0 extends ListenerAdapter {


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {



            if (test.on_of) {
                String message = event.getMessage().getContentRaw();
                System.out.println(message);

                try {
                    // API endpoint URL
                    URL url = new URL("https://neutrinoapi.net/bad-word-filter");

                    // Create connection
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

                    // Request parameters
                    String userId = "salzstange_app";
                    String apiKey = "TwaDSWQKaMWqgXyA40TsjTqtJOpqWZbHea1jVGdYswu87Req";
                    String content = message;

                    // Build request body
                    String requestBody = "user-id=" + encode(userId, "UTF-8")
                            + "&api-key=" + encode(apiKey, "UTF-8")
                            + "&content=" + encode(content, "UTF-8");

                    // Enable output and send request
                    connection.setDoOutput(true);
                    OutputStream outputStream = connection.getOutputStream();
                    outputStream.write(requestBody.getBytes("UTF-8"));
                    outputStream.close();

                    // Get the response
                    int responseCode = connection.getResponseCode();

                    BufferedReader reader;
                    // Successful response
                    if (responseCode == HttpURLConnection.HTTP_OK)
                        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    else {
                        // Error response
                        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    }

                    // Read the response
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();


                    Boolean isBad = Boolean.valueOf(response.substring(32, 36));


                    if (isBad) {

                        event.getMessage().delete().queue();
                        event.getMessage().getAuthor().openPrivateChannel().complete().sendMessage("Pls don't say Bad words").queue();
                        event.getGuild().timeoutFor(event.getGuild().getMemberById(event.getMessage().getAuthor().getId()).getUser(), 60, TimeUnit.SECONDS).queue();

                    }


                    // Disconnect the connection
                    connection.disconnect();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
}