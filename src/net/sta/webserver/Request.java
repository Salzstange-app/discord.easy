package net.sta.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Request {
    public static void connection() {
        try {
            URLConnection urlConnection = new URL("http://localhost:8080/MemberEffectiveName").openConnection();
            HttpURLConnection con = (HttpURLConnection) urlConnection;
            con.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //System.out.println(reader.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
