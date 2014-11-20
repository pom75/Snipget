package tpdev.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONException;
import org.json.JSONObject;

import tpdev.tools.Conteneur;
import tpdev.tools.Tools;

public class SendListener implements ActionListener {
	
	public void actionPerformed(ActionEvent arg0) {
		
		if (Tools.id == -1) {
			Conteneur.infoPostLabel.setText("Vous n'êtes pas connecté !");
			return;
		}
		
		String title = Conteneur.titreField.getText();
		String tags = Conteneur.tagsFieldPost.getText();
		String code = Conteneur.codeArea.getText().replace("\n", "<br>");
		String language;
		
		if (Conteneur.javaRadio.isSelected()) language = "Java";
		else language = "C";
		
		try {
			JSONObject resp = Tools.envoyerRequete("api2/snippet/add?title="+title
					+"&id_user="+Tools.id+"&content="+code+"&tag="+tags+"&lang="+language);
			
			
			int x = 3;
			if (x == 2) throw new JSONException("");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
