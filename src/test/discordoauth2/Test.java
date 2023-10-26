package test.discordoauth2;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Spark;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
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
           // HttpsURLConnection connection= tokenTausch(code);

           // if (connection.getResponseCode() == 200) {

             //   JsonObject responseToken = getToken(connection);
               // UserData.add(getUserData(responseToken));
                response.redirect("http://localhost:63342/discord.easy/src/test/discordoauth2/test.html?_ijt=n42lgvil12cd6cmhob67d40dvd&_ij_reload=RELOAD_ON_SAVE");

         //   }

            return "Fehler beo der Authentifizierung";
        });
        Spark.get("/data", (request, response) -> {
            return UserData.get(0);
        });
    }


    /*
    private static JsonObject getToken(HttpsURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        JsonObject responseToken = null;
        // System.out.println("reader " + reader.readLine());
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

     */
}
