package tpdev.actions;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Conteneur {

	// inscription / connexion
	public static JFrame loginFrame;
	public static JLabel loginLabel, passwordLabel;
	public static JTextField loginField, passwordField;
	public static JButton connexionButton, inscriptionButton;
	public static JLabel infoLoginLabel;
	
	// get snippet
	public static JFrame getFrame;
	public static JLabel tagsLabelGet;
	public static JTextField tagsFieldGet;
	public static JButton rechercherButton;
	public static JLabel infoGetLabel;
	
	// post snippet
	public static JFrame postFrame;
	public static JLabel titreLabel, tagsLabelPost, codeLabel;
	public static JTextField titreField, tagsFieldPost;
	public static JTextArea codeArea;
	public static JScrollPane codeScroll;
	public static JButton sendButton;
	public static JRadioButton javaRadio, cRadio;
	public static ButtonGroup groupeLanguageRadio;
	public static JLabel infoPostLabel;
	
	// response
	public static JFrame responseFrame;
	public static JTextArea responseArea;
	public static JScrollPane responseScroll;
	public static JLabel noterLabel;
	public static JLabel idSnippetLabel, noteLabel;
	public static JTextField idSnippetField;
	public static JRadioButton pourRadio, contreRadio;
	public static ButtonGroup groupePourContreRadio;
	public static JButton noterButton;
	public static JLabel infoResponseLabel;

}
