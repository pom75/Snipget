package tpdev.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONException;
import org.json.JSONObject;

import tpdev.tools.Conteneur;
import tpdev.tools.Tools;

public class ConnexionListener implements ActionListener  {

	public void actionPerformed(ActionEvent arg0) {
		String login = Conteneur.loginField.getText();
		String password = Conteneur.passwordField.getText();

		try {
			JSONObject resp = Tools.envoyerRequete("api2/user/log?name="+login+"&password="+password);

			int entity = resp.getInt("entity");
			
			if (entity == -1) {
				Conteneur.infoLoginLabel.setText("Erreur : login ou mot de passe incorrect");
				return;
			}
			
			Conteneur.infoLoginLabel.setText("Vous êtes connecté !");
			Tools.id = entity;
			Conteneur.infoPostLabel.setText("");
			Conteneur.infoResponseLabel.setText("");
			
		} catch (JSONException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
