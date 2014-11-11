package tpdev.actions;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import horloge.text.HorlogeTexte;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
public class GetAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public GetAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Get a Snippet");
		JLabel info = new JLabel();
		
		JPanel gui = new JPanel(new BorderLayout(3,2));

        JPanel labelFields = new JPanel(new BorderLayout(2,2));

        JPanel labels = new JPanel(new GridLayout(0,1,1,1));
        JPanel fields = new JPanel(new GridLayout(0,1,1,1));
        
        labels.add(new JLabel("Tags :"));
        fields.add(new JTextField(20));
        labels.add( new JButton("Rechercher") );
        fields.add(new JLabel());

        labelFields.add(labels, BorderLayout.CENTER);
        labelFields.add(fields, BorderLayout.EAST);

        gui.add(labelFields, BorderLayout.NORTH);

        info.setText("<html>Pour chercher un Snippet , tapez dans la champ 'Tag' <br> "
        		+ " tapez vos tags séparé par une virgule exemple : tag1 , tag2  </html>");
	    
        gui.add(info, BorderLayout.SOUTH);
        
        fenetre.add(gui);
	    fenetre.pack();
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