package net.sta.oauth2;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class RequestManager {

    @Getter protected static String clientId = "";
    @Getter protected static String clientSecret = "";
    @Getter protected static String redirectUri = ""; //Callback-URL
    protected static ArrayList<String> UserData = new ArrayList<>();
    public RequestManager(String ClientId, String ClientSecret, String RedirectUri){
        clientId = ClientId;
        clientSecret = ClientSecret;
        redirectUri = RedirectUri;
    }
    protected static JsonObject getToken(@NotNull HttpsURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        JsonObject responseToken = null;
        // System.out.println("reader " + reader.readLine());
        while ((line = reader.readLine()) != null) {
            responseToken = JsonParser.parseString(line).getAsJsonObject();
            return responseToken;
        }
        return null;
    }
    protected static String getUserData(@NotNull JsonObject responseToken) throws IOException  {
        try {
            HttpsURLConnection userConnection = (HttpsURLConnection) new URI("https://discord.com/api/v10/users/@me").toURL().openConnection();
            userConnection.setRequestProperty("Authorization", "Bearer " + responseToken.get("access_token").getAsString());

            if (userConnection.getResponseCode() == 200) {
                return new BufferedReader(new InputStreamReader(userConnection.getInputStream())).readLine();
            }
            return null;
        }catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    protected static HttpsURLConnection tokenTausch(@NotNull String AuthorizationCode) throws IOException {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URI("https://discord.com/api/oauth2/token").toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            String data = "client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=authorization_code&code=" + AuthorizationCode + "&redirect_uri=" + redirectUri;
            connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
            return connection;
        }catch (URISyntaxException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
