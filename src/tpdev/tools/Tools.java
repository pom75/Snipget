package tpdev.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Tools {

	/** Adresse du serveur */
	public static final String adresse = "http://snipget.mybluemix.net/";
	
	/** Id de l'utilisateur connecté */
	public static int id = -1;

	public static String readAll (BufferedReader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	/**
	 * Envoi la requête au serveur.
	 * @param url url à envoyer (voir API)
	 * @return le Json répondu par le serveur 
	 */
	public static JSONObject envoyerRequete (String url) {
		String str = null;
		try {
			
			URL url1 = new URL(adresse+url);
			URI uri = new URI(url1.getProtocol(), url1.getUserInfo(), url1.getHost(), url1.getPort(), url1.getPath(), url1.getQuery(), url1.getRef());
			System.out.println("[Requête envoyée] : "+adresse+url);
			URL u = uri.toURL();
			BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
			str = readAll(in);
			System.out.println("[Réponse] : "+str);
			in.close();
			
		} catch (IOException e) {
			System.err.println("IOException while try to send url : "+url);
			e.printStackTrace();
			return null;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return new JSONObject(str);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	public static String snippetToString (String snippetID) {
		
		JSONObject snippet;
		String entity;
		JSONObject entityObject;
		String title, language, code, tags;
		int userID, pour, contre;
		
		try {
			snippet = envoyerRequete("api2/snippet/get?id="+snippetID);
			entity = snippet.getString("entity");
			entityObject = new JSONObject(entity);
			
			title = entityObject.getString("title");
			language = entityObject.getString("language");
			code = entityObject.getString("content");
			userID = entityObject.getInt("id_user");
			tags = entityObject.getString("tags");
			
			snippet = envoyerRequete("api2/vote/get?id_snippet="+snippetID);
			entity = snippet.getString("entity");
			entityObject = new JSONObject(entity);
			
			pour = entityObject.getInt("pour");
			contre = entityObject.getInt("contre");
			
			return "Snippet "+snippetID+"\nTitre : "+title+"\nLanguage : "+language+
					"\nPosté par "+userID+"\nTags : "+tags+
					"\n"+pour+" votes pour, "+contre+" votes contre"+
					"\nCode :\n"+code.replace("<br>", "\n")+"\n\n\n";
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return "Error";
	}


}
