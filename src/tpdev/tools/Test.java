package tpdev.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main (String [] args) {
/*
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
		*/
		
String str = "{\"entity\":\"[{\"id\": \"11\", \"title\": \"Mon titre\", \"language\": \"Java\", \"content\": \"Mon code \",  \"id_user\": \"10\",\"tags\": \"tag1,tag3,tag,test\"}, {\"id\": \"21\", \"title\": \"titre\", \"language\": \"C\", \"content\": \"rrrr\",  \"id_user\": \"-1\",\"tags\": \"tags\"}, {\"id\": \"31\", \"title\": \"Mon titre\", \"language\": \"Java\", \"content\": \"mon code\",  \"id_user\": \"321\",\"tags\": \"tag1,tag2\"},{\"id\": \"41\", \"title\": \"Mon titre\", \"language\": \"Java\", \"content\": \"mon code\n\nzdzd\n\nazdzad\",  \"id_user\": \"321\",\"tags\": \"tag1,tag2\"}]\",\"metadata\":{},\"status\":200}";
		try {
			str = str.replace("\"[", "[");
			str = str.replace("]\"", "]");
			str = str.replace("\n", "<br>");
			JSONObject json = new JSONObject(str);
			System.out.println(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
