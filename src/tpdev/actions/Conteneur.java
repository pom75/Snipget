package tpdev.actions;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Conteneur {

	// inscription / connexion
	public JFrame loginFrame;
	public JLabel loginLabel, passwordLabel;
	public JTextField loginField, passwordField;
	public JButton connexionButton, inscriptionButton;
	public JLabel infoLoginLabel;
	
	// get snippet
	public JFrame getFrame;
	public JLabel tagsLabelGet;
	public JTextField tagsFields;
	public JButton rechercherButton;
	public JLabel infoGetLabel;
	
	// post snippet
	public JFrame postFrame;
	public JLabel titreLabel, tagsLabelPost, codeLabel;
	public JTextField titreField, tagsField;
	public JScrollPane codeScroll;
	public JButton sendButton;
	public JRadioButton javaRadio, cRadio;
	public ButtonGroup groupeRadio;
	public JLabel infoPostLabel;

}
