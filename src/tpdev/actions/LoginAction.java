package tpdev.actions;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import tpdev.listeners.ConnexionListener;
import tpdev.listeners.InscriptionListener;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class LoginAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	private JPanel gui;
	private JPanel labelFields;
	private JPanel labels; 
	private JPanel fields;
	private Conteneur conteneur;


	/**
	 * The constructor.
	 */
	public LoginAction() {
		conteneur = new Conteneur();
		
		conteneur.loginFrame = new JFrame("Login");
		gui = new JPanel(new BorderLayout(3,2));
		labelFields = new JPanel(new BorderLayout(2,2));
		labels = new JPanel(new GridLayout(0,1,1,1));
		fields = new JPanel(new GridLayout(0,1,1,1));
		
		conteneur.infoLoginLabel = new JLabel();
		conteneur.loginLabel = new JLabel("Login :");
		conteneur.passwordLabel = new JLabel("Password :");
		labels.add(conteneur.loginLabel);
		labels.add(conteneur.passwordLabel);

		conteneur.loginField = new JTextField(20);
		conteneur.passwordField = new JTextField(10);
		fields.add(conteneur.loginField);
		fields.add(conteneur.passwordField);

		conteneur.connexionButton = new JButton("Connexion");
		conteneur.inscriptionButton = new JButton("Inscription");
		labels.add(conteneur.connexionButton);
		fields.add(conteneur.inscriptionButton);
		
		conteneur.connexionButton.addActionListener(new ConnexionListener(conteneur));
		conteneur.inscriptionButton.addActionListener(new InscriptionListener(conteneur));

		labelFields.add(labels, BorderLayout.CENTER);
		labelFields.add(fields, BorderLayout.EAST);

		gui.add(labelFields, BorderLayout.NORTH);

		conteneur.infoLoginLabel.setText("<html> Complétez les champs ci-dessus. <br> "
				+ "Si Vous avez déja un compte cliquez simplement sur Connexion <br> "
				+ "Sinon cliquez sur Inscription </html>");

		gui.add(conteneur.infoLoginLabel, BorderLayout.SOUTH);

		conteneur.loginFrame.add(gui);
		conteneur.loginFrame.pack();
	}


	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		conteneur.loginFrame.setVisible(true);
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
	
}