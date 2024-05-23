package net.sta.webserver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DiscordOAuth2 {
    static String clientId = "";
    static String clientSecret = "";
    static String redirectUri = "http://localhost:8080/callback";
    static ArrayList<String> UserData = new ArrayList<>();

    private static String DiscordAccessToken = "";
    private static String DiscordRefreshToken = "";

    static Boolean DiscordOAuth2(String queryCode){

        try {
            HttpsURLConnection connection = tokenTausch(queryCode);
            if (connection.getResponseCode() == 200) {

                JsonObject responseToken = getToken(connection);

                DiscordAccessToken = String.valueOf(responseToken.get("access_token"));
                DiscordRefreshToken = String.valueOf(responseToken.get("refresh_token"));

                System.out.println("DiscordAccessToken: " + DiscordAccessToken);
                System.out.println("DiscordRefreshToken: " + DiscordRefreshToken);

                if (!UserData.isEmpty()) {
                    for (String s : UserData) {
                        if (UserData.contains(s)) {
                            System.out.println(UserData.size());
                        } else {
                            UserData.add(getUserData(responseToken));
                        }
                    }
                } else {
                    UserData.add(getUserData(responseToken));
                }
                return true;
            }else {
                return false;
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    private static JsonObject getToken(HttpsURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        JsonObject responseToken = null;
        while ((line = reader.readLine()) != null) {
            responseToken = JsonParser.parseString(line.toString()).getAsJsonObject();
            return responseToken;
        }
        return null;
    }
    private static String getUserData(JsonObject responseToken) throws IOException {
        HttpsURLConnection userConnection = (HttpsURLConnection) new URL("https://discord.com/api/v10/users/@me").openConnection();
        userConnection.setRequestProperty("Authorization", "Bearer " + responseToken.get("access_token").getAsString());
        if (userConnection.getResponseCode() == 200) {
            return new BufferedReader(new InputStreamReader(userConnection.getInputStream())).readLine();
        }
        return null;
    }

    private static HttpsURLConnection tokenTausch(String AuthorizationCode) throws IOException {
        HttpsURLConnection connection = (HttpsURLConnection) new URL("https://discord.com/api/oauth2/token").openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);
        String data = "client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=authorization_code&code=" + AuthorizationCode + "&redirect_uri=" + redirectUri;
        connection.getOutputStream().write(data.getBytes("UTF-8"));
        return connection;
    }
}


