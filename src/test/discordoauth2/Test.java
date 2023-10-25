package test.discordoauth2;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Spark;
import spark.Spark.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import static spark.Spark.before;
import static spark.Spark.port;

public class Test {

    static String clientId = "1137845443976503347";
    static String clientSecret = "gPSR3ylPD4ky8vekyUgQR4QKOaj-FvGc";
    static String redirectUri = "http://localhost:9595/callback"; //Callback-URL
    static ArrayList<String> UserData = new ArrayList<>();


    public static void main(String[] args) {

        port(9595);
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "http://localhost:63342");
            response.header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With, Content-Length, Accept, Origin");
            response.type("application/json");
        });

        Spark.get("/", (request, response) -> {
            response.redirect("http://localhost:9595/login");
            return null;
        });

        Spark.get("/login", (request, response) -> {
            response.redirect("https://discord.com/oauth2/authorize?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&response_type=code&scope=identify");
            return null;
        });


        Spark.get("/callback", (request, response) -> {
            //gettet die queryParameter nach code=
            String code = request.queryParams("code");

            // Token-Austausch
            HttpsURLConnection connection = (HttpsURLConnection) new URL("https://discord.com/api/oauth2/token").openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            String data = "client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=authorization_code&code=" + code + "&redirect_uri=" + redirectUri;
            connection.getOutputStream().write(data.getBytes("UTF-8"));


            if (connection.getResponseCode() == 200) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                JsonObject responseToken = null;
                while ((line = reader.readLine()) != null) {
                    responseToken = JsonParser.parseString(line.toString()).getAsJsonObject();
                }

                // Verwende das AccessToken, um Discord-Benutzerdaten abzurufen
                HttpsURLConnection userConnection = (HttpsURLConnection) new URL("https://discord.com/api/v10/users/@me").openConnection();
                userConnection.setRequestProperty("Authorization", "Bearer " + responseToken.get("access_token").getAsString());

                if (userConnection.getResponseCode() == 200) {
                    BufferedReader userReader = new BufferedReader(new InputStreamReader(userConnection.getInputStream()));

                  UserData.add(userReader.readLine());
                    response.redirect("http://localhost:63342/discord.easy/src/test/discordoauth2/test.html?_ijt=n42lgvil12cd6cmhob67d40dvd&_ij_reload=RELOAD_ON_SAVE");
                    return null;
                }
            }

            return "Fehler beo der Authentifizierung";
        });
        Spark.get("/data", (request, response) -> {
            return UserData.get(0);
        });
    }
}
