package tpdev.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONException;
import org.json.JSONObject;

import tpdev.actions.Conteneur;
import tpdev.tools.Tools;

public class ConnexionListener implements ActionListener  {

	private Conteneur conteneur;

	public ConnexionListener (Conteneur c) {
		conteneur = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		String login = conteneur.loginField.getText();
		String password = conteneur.passwordField.getText();

		try {
			JSONObject resp = Tools.envoyerRequete("api2/user/log?name="+login+"&password="+password);

			int entity = resp.getInt("entity");
			
			if (entity == -1) {
				conteneur.infoLoginLabel.setText("Erreur : login ou mot de passe incorrect");
				return;
			}
			
			conteneur.infoLoginLabel.setText("Vous êtes connecté !");
			Tools.id = entity;

			// TODO : attendre avant de fermer...
			conteneur.loginFrame.dispose();
			
		} catch (JSONException ex) {
			ex.printStackTrace();
		} 
	}

}
