package tpdev.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONException;
import org.json.JSONObject;

import tpdev.actions.Conteneur;
import tpdev.tools.Tools;


public class InscriptionListener implements ActionListener {
	
	private Conteneur conteneur;
	
	public InscriptionListener (Conteneur c) {
		conteneur = c;
	}
	
	/*
	 * réponse si utilisateur déjà inscrit : {"status":500,"entity":null,"metadata":{}}
	 */
	
	public void actionPerformed(ActionEvent e) {
		String login = conteneur.loginField.getText();
		String password = conteneur.passwordField.getText();

		try {
			JSONObject resp = Tools.envoyerRequete("api2/user/add?name="+login+"&password="+password);
			//System.out.println("Réponse : "+resp);
			
			int status = resp.getInt("status");
			//System.out.println("Statut : "+status);
			
			if (status == 500) {
				conteneur.infoLoginLabel.setText("Erreur : login déjà utilisé");
			} else {
				conteneur.infoLoginLabel.setText("Vous êtes inscrit !\nConnectez-vous maintenant");
			}

		} catch (JSONException ex) {
			ex.printStackTrace();
		}
	}
}
