package tpdev.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tpdev.actions.Conteneur;
import tpdev.actions.Response;
import tpdev.tools.Tools;

public class RechercherListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		Set<Integer> ids = new HashSet<Integer>();
		String tagsString = Conteneur.tagsFieldGet.getText();
		String [] tags = tagsString.split(",");
		int length = tags.length;
		JSONObject [] resp = new JSONObject[length];
		String [] entities = new String[length];

		try {
			for (int i = 0 ; i<length ; i++) {
				resp[i] = Tools.envoyerRequete("api2/snippet/search?tag="+tags[i]);
				entities[i] = resp[i].getString("entity");
				//System.out.println("String entity : "+entities[i]);
				
				JSONArray array = new JSONArray(entities[i]);
				for (int j = 0 ; j<array.length() ; j++) {
					JSONObject tmp = array.getJSONObject(j);
					ids.add(tmp.getInt("id"));
				}
			}
			
			Iterator<Integer> it = ids.iterator();
			String resultat = "";
			
			while (it.hasNext()) {
				resultat += Tools.snippetToString(String.valueOf(it.next()));
			}
			
			Response r = new Response();			
			r.setText(resultat);

		} catch (JSONException ex) {
			ex.printStackTrace();
		}
	}

}
