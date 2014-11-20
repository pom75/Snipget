package tpdev.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tpdev.tools.Conteneur;
import tpdev.tools.Tools;

public class VoteListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		
		if (Tools.id == -1) {
			Conteneur.infoResponseLabel.setText("Il faut être connecté pour voter !");
			return;
		}
		
		String snippetID = Conteneur.idSnippetField.getText();
		String vote;
		
		if (Conteneur.pourRadio.isSelected()) vote = "true";
		else vote = "false";
		
		Tools.envoyerRequete("api2/vote/add?id_snippet="+snippetID+
				"&id_user="+Tools.id+"&vote="+vote);
		
		Conteneur.infoResponseLabel.setText("Votre vote est enregistré !");
	
	}

}
