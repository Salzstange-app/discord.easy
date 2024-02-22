package net.sta.webserver;
import static spark.Spark.*;
import net.dv8tion.jda.api.JDA;
import net.sta.webserver.web.modules.BanUser;
import net.sta.webserver.web.modules.KickUser;

import java.util.Arrays;
import java.util.List;

public class Webserver {
	
	public Webserver(JDA jda) {
		startWebserver(jda);
		System.out.println("Webserver ist Online");
		System.out.println(" " +  " http://localhost:8080/");
	//	Request.connection();
	}
	
	private void startWebserver(JDA jda) {
		port(8080);


		before((request, response) -> {
			//response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Origin", "http://localhost:63342");
			response.header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
			response.header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With, Content-Length, Accept, Origin");
			response.type("application/json");
		});


		//hier werden dann die sachen auf diesen endpoint geschickt
		get("/api/dc/Member", "application/json", (request, response) -> {
			return new ToJson(jda).Member().toString();
		});

		get("/api/dc/MemberAvatarUrl", "application/json", (request, response) -> {
			return new ToJson(jda).AvatarUrl() != null ? new ToJson(jda).AvatarUrl() : "liste ist leer";

		});


		//post request tauscht sozusagen daten aus mit dem web panel
		post("/api/dc/BanUser", (request, response) -> {
			//alle daten
			String r = request.body().toString();

			//ich splitte alles was mit einem minus abgezeichnet ist somit habe ich id und reason
			List<String> s = Arrays.stream(r.split("-")).toList();

			String memberId = "";

			//entfernt die klammern und holt sich die Id
			int startIndex = s.get(0).indexOf("(");
			int endIndex = s.get(0).indexOf(")");
			if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
				memberId = s.get(0).substring(startIndex + 1, endIndex);
			}

			System.out.println(memberId + " " + s.get(1));
			//schickt daten rüber in eine andere klasse und dort wird er gebannt
            new BanUser(memberId,s.get(1));

			//schickt eine Nachricht zurück wenn alles gut gelaufen ist
			return "{\"message\": \"Daten empfangen und verarbeitet\"}";
		});


		post("/api/dc/KickUser", (request, response) -> {
			//alle daten
			String r = request.body().toString();

			System.out.println("test");
			//ich splitte alles was mit einem minus abgezeichnet ist somit habe ich id und reason
			List<String> s = Arrays.stream(r.split("-")).toList();

			String memberId = "";

			//entfernt die klammern und holt sich die Id
			int startIndex = s.get(0).indexOf("(");
			int endIndex = s.get(0).indexOf(")");
			if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
				memberId = s.get(0).substring(startIndex + 1, endIndex);
			}

			System.out.println(memberId + " " + s.get(1));
			//schickt daten rüber in eine andere klasse und dort wird er gebannt
			new KickUser(memberId,s.get(1));

			//schickt eine Nachricht zurück wenn alles gut gelaufen ist
			return "{\"message\": \"Daten empfangen und verarbeitet\"}";
		});



		get("/", (request, response) -> {

			return "Test";

		});


		/*

	DiscordOauth2
 	das ist das ganze ouath2 discord scheiße das wollte ich austesten weil das mir ChatGpt gesagt hat und so wie es ist fonktoniert nur die hälfte kann
 	ned die sachen getten =((
		get("/login", (req, res) -> {
			// Erstelle deinen Discord OAuth2-URL hier
			String discordOAuthUrl = "https://discord.com/api/oauth2/authorize?client_id=1137845443976503347&redirect_uri=http://localhost:8080/callback&response_type=code&scope=identify";

			// Leite den Benutzer zur Discord-Anmeldeseite weiter
			res.redirect(discordOAuthUrl);
			return null;
		});

		// Callback-Endpunkt für Discord OAuth2
		get("/callback", (req, res) -> {
			// Verarbeite die Autorisierungsdaten, die Discord zurückschickt
			String code = req.queryParams("code");
			System.out.println(code);

			// Tausche den Autorisierungscode gegen ein Token aus und verifiziere den Benutzer
			// Hier solltest du die Discord OAuth2-Flow implementieren

			// Zeige eine Benutzeroberfläche für den angemeldeten Benutzer an oder speichere die Informationen in einer Sitzung



			String clientId = "1137845443976503347";
			String clientSecret = "-POBpMNNJPYdFFIKH1Gr2wzFTc3Tj9dU";
			String redirectUri = "http://localhost:8080/callback";
            try {
				// Schritt 1: Token-Austausch
				URL tokenUrl = new URL("https://discord.com/api/oauth2/token");
				HttpURLConnection tokenConnection = (HttpURLConnection) tokenUrl.openConnection();
				tokenConnection.setRequestMethod("POST");
				tokenConnection.setDoOutput(true);

				// Basic Authentication
				String auth = clientId + ":" + clientSecret;
				String authHeader = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
				tokenConnection.setRequestProperty("Authorization", authHeader);

				String tokenParams = "client_id=" + clientId +
						"&client_secret=" + clientSecret +
						"&code=" + code +
						"&grant_type=authorization_code" +
						"&redirect_uri=" + redirectUri;

				try (OutputStream os = tokenConnection.getOutputStream()) {
					byte[] input = tokenParams.getBytes("utf-8");
					os.write(input, 0, input.length);
				}

				int tokenResponseCode = tokenConnection.getResponseCode();
				if (tokenResponseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader tokenReader = new BufferedReader(new InputStreamReader(tokenConnection.getInputStream()));
					String tokenResponse = tokenReader.readLine();
					tokenReader.close();
					System.out.println("Token Response: " + tokenResponse);

					// Schritt 2: Benutzerinformationen abrufen
					URL userUrl = new URL("https://discord.com/api/v10/users/@me");
					HttpURLConnection userConnection = (HttpURLConnection) userUrl.openConnection();
					userConnection.setRequestProperty("Authorization", "Bearer " + tokenResponse);
					userConnection.setRequestMethod("GET");

					int userResponseCode = userConnection.getResponseCode();
					if (userResponseCode == HttpURLConnection.HTTP_OK) {
						BufferedReader userReader = new BufferedReader(new InputStreamReader(userConnection.getInputStream()));
						String userResponse = userReader.readLine();
						userReader.close();
						System.out.println("User Response: " + userResponse);
					} else {
						System.err.println("Fehler beim Abrufen der Benutzerinformationen. Code: " + userResponseCode);
					}
				} else {
					System.err.println("Fehler beim Token-Austausch. Code: " + tokenResponseCode);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}





			return "Erfolgreich authentifiziert!";
		});
*/


		awaitInitialization();

	}



}
