package tpdev.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Tools {

	/** Adresse du serveur */
	public static final String adresse = "http://snipget.mybluemix.net/";

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
		try {
			URL u = new URL(adresse+url);
			BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
			String str = readAll(in);
			//System.out.println("String : "+str);
			in.close();
			return new JSONObject(str); 
		} catch (IOException e) {
			System.err.println("IOException while try to send url : "+url);
			e.printStackTrace();
			return null;
		} catch (JSONException e) {
			System.err.println("JSONException while try to send url : "+url);
			e.printStackTrace();
			return null;
		}
	}


}
