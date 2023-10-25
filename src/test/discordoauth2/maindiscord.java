package test.discordoauth2;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Spark;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static spark.Spark.before;

public class maindiscord {


    static ArrayList<String> test = new ArrayList<>();
    public static void main(String[] args) {
        // Discord-Anwendungseinstellungen
        String clientId = "1137845443976503347";
        String clientSecret = "gPSR3ylPD4ky8vekyUgQR4QKOaj-FvGc";
        String redirectUri = "http://localhost:4567/callback"; // Deine Callback-URL

        // Starte die OAuth 2.0 Authentifizierung
        Spark.get("/login", (req, res) -> {
            res.redirect("https://discord.com/oauth2/authorize?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&response_type=code&scope=identify");
            return null;
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "http://localhost:63342");
            response.header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With, Content-Length, Accept, Origin");
            response.type("application/json");
        });




        // Callback-Route
        Spark.get("/callback", (req, res) -> {
            String code = req.queryParams("code");

            // Token-Austausch
            String tokenUrl = "https://discord.com/api/oauth2/token";
            URL url = new URL(tokenUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            String data = "client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=authorization_code&code=" + code + "&redirect_uri=" + redirectUri;
            connection.getOutputStream().write(data.getBytes("UTF-8"));

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JsonObject tokenData = JsonParser.parseString(response.toString()).getAsJsonObject();
                String accessToken = tokenData.get("access_token").getAsString();

                // Verwende das AccessToken, um Discord-Benutzerdaten abzurufen
                String userUrl = "https://discord.com/api/v10/users/@me";
                URL userApiUrl = new URL(userUrl);
                HttpURLConnection userConnection = (HttpURLConnection) userApiUrl.openConnection();
                userConnection.setRequestProperty("Authorization", "Bearer " + accessToken);

                int userResponseCode = userConnection.getResponseCode();
                if (userResponseCode == 200) {
                    BufferedReader userReader = new BufferedReader(new InputStreamReader(userConnection.getInputStream()));
                    StringBuilder userResponse = new StringBuilder();
                    while ((line = userReader.readLine()) != null) {
                        userResponse.append(line);
                    }
                    userReader.close();

                    // Hier kannst du die Discord-Benutzerdaten verwenden
               //     test.add(1, userResponse.toString());
                 //   System.out.println(test.get(1));
                  //  System.out.println(test.get(0));
                    System.out.println(userResponse.toString());
                    test.add(userResponse.toString());
                    System.out.println("test");
                   // return "Discord Benutzerdaten: " + userResponse.toString();
                    res.redirect("http://localhost:63342/discord.easy/src/test/discordoauth2/test.html?_ijt=n42lgvil12cd6cmhob67d40dvd&_ij_reload=RELOAD_ON_SAVE");
                    return null;

                }
            }

            return "Fehler beim Authentifizieren mit Discord.";
        });

        Spark.get("/data", (request, response) -> {
            return test.get(0);

        });
    }

}
