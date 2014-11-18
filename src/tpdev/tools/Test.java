package tpdev.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main (String [] args) {

		String adresse = "http://snipget.mybluemix.net/";

		try {

			URL url = new URL(adresse+"api2/user/get?id=161");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String str = Tools.readAll(in);
			System.out.println("String : "+str);
			in.close();

			JSONObject json = new JSONObject(str);
			System.out.println("Json : "+json.toString());

			String entity = json.getString("entity");
			System.out.println("\nEntity = "+entity);
			
			JSONObject entityObject = new JSONObject(entity); 
			
			String id = entityObject.getString("id");
			String name = entityObject.getString("name");
			
			System.out.println("ID : "+id+"\nName = "+name);
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

}
