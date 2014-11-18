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
public class GetAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	private JFrame fenetre;
	private JLabel info;
	private JPanel gui;
	private JPanel labelFields;
	private JPanel labels;
	private JPanel fields;

	private JLabel tagsLabel;
	private JTextField tagsFields;
	private JButton rechercherButton;

	/**
	 * The constructor.
	 */
	public GetAction() {
		fenetre = new JFrame();
		fenetre.setTitle("Get a Snippet");
		info = new JLabel();
		gui = new JPanel(new BorderLayout(3,2));
		labelFields = new JPanel(new BorderLayout(2,2));
		labels = new JPanel(new GridLayout(0,1,1,1));
		fields = new JPanel(new GridLayout(0,1,1,1));

		tagsLabel = new JLabel("Tags :");
		tagsFields = new JTextField(20);
		labels.add(tagsLabel);
		fields.add(tagsFields);

		rechercherButton = new JButton("Rechercher");
		labels.add(rechercherButton);
		addButtonActionListener(rechercherButton);
		
		// label bouche-trou
		fields.add(new JLabel(""));

		labelFields.add(labels, BorderLayout.CENTER);
		labelFields.add(fields, BorderLayout.EAST);

		gui.add(labelFields, BorderLayout.NORTH);

		info.setText("<html>Pour chercher un Snippet , tapez dans le champ 'Tags' <br> "
				+ " Tapez vos tags séparés par une virgule. Exemple : tag1,tag2  </html>");

		gui.add(info, BorderLayout.SOUTH);

		fenetre.add(gui);
		fenetre.pack();
	}
	
	private void addButtonActionListener (JButton rechercherButton) {
		
		rechercherButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO
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