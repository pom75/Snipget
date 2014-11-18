package tpdev.actions;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

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
	
	private JFrame fenetre;
	private JLabel info;
	private JPanel gui;
    private JPanel labelFields;
    private JPanel labels; 
    private JPanel fields;
    private JLabel loginLabel, passwordLabel;
    private JTextField loginField, passwordField;
    private JButton connexionButton, inscriptionButton;
    
	/**
	 * The constructor.
	 */
	public LoginAction() {
		fenetre = new JFrame("Login");
		info = new JLabel();
		gui = new JPanel(new BorderLayout(3,2));
        labelFields = new JPanel(new BorderLayout(2,2));
        labels = new JPanel(new GridLayout(0,1,1,1));
        fields = new JPanel(new GridLayout(0,1,1,1));
        
        loginLabel = new JLabel("Login :");
        passwordLabel = new JLabel("Password :");
        labels.add(loginLabel);
        labels.add(passwordLabel);
        
        loginField = new JTextField(20);
        passwordField = new JTextField(10);
        fields.add(loginField);
        fields.add(passwordField);
        
        connexionButton = new JButton("Connexion");
        inscriptionButton = new JButton("Inscription");
        labels.add(connexionButton);
        fields.add(inscriptionButton);
        // ajout des méthodes appelées par les boutons
        addButtonActionListener(connexionButton, inscriptionButton);

        labelFields.add(labels, BorderLayout.CENTER);
        labelFields.add(fields, BorderLayout.EAST);

        gui.add(labelFields, BorderLayout.NORTH);

        info.setText("<html> Complétez les champs ci-dessus. <br> "
        		+ "Si Vous avez déja un compte cliquez simplement sur Connexion <br> "
        		+ "Sinon cliquez sur Inscription </html>");
	    
        gui.add(info, BorderLayout.SOUTH);
        
        fenetre.add(gui);
	    fenetre.pack();
	}
	
	private void addButtonActionListener (JButton connexion, JButton inscription) {
		
		connexion.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		inscription.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		fenetre.setVisible(true);
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