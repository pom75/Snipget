package tpdev.actions;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import tpdev.listeners.SendListener;
import tpdev.tools.Conteneur;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class PostAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	private JPanel gui;
	private JPanel labelFields;
	private JPanel labels;
	private JPanel fields;
	private JPanel radioPanel;
	
	/**
	 * The constructor.
	 */
	public PostAction() {
		
		Conteneur.postFrame = new JFrame();
		Conteneur.postFrame.setTitle("Post a Snippet");
		gui = new JPanel(new BorderLayout(3,2));
		labelFields = new JPanel(new BorderLayout(2,2));
		labels = new JPanel(new GridLayout(0,1,1,1));
		fields = new JPanel(new GridLayout(0,1,1,1));
		radioPanel = new JPanel(new GridLayout(1, 0, 1, 1));

		Conteneur.titreLabel = new JLabel("Titre :");
		Conteneur.titreField = new JTextField(10); 
		labels.add(Conteneur.titreLabel);
		fields.add(Conteneur.titreField);

		Conteneur.tagsLabelPost = new JLabel("Tags :");
		Conteneur.tagsFieldPost = new JTextField(10); 
		labels.add(Conteneur.tagsLabelPost);
		fields.add(Conteneur.tagsFieldPost);

		Conteneur.codeLabel = new JLabel("Code :");
		Conteneur.codeArea = new JTextArea(5, 30);
		Conteneur.codeScroll = new JScrollPane(Conteneur.codeArea, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		labels.add(Conteneur.codeLabel);
		fields.add(Conteneur.codeScroll);

		Conteneur.sendButton = new JButton("Send "); 
		labels.add(Conteneur.sendButton);
		Conteneur.sendButton.addActionListener(new SendListener());
		
		Conteneur.infoPostLabel = new JLabel();
		fields.add(Conteneur.infoPostLabel);
		
		Conteneur.javaRadio = new JRadioButton("Java");
		Conteneur.cRadio = new JRadioButton("C");
		Conteneur.javaRadio.setSelected(true);
		Conteneur.groupeLanguageRadio = new ButtonGroup();
		Conteneur.groupeLanguageRadio.add(Conteneur.javaRadio);
		Conteneur.groupeLanguageRadio.add(Conteneur.cRadio);
		radioPanel.add(Conteneur.javaRadio);
		radioPanel.add(Conteneur.cRadio);
		fields.add(radioPanel);

		labelFields.add(labels, BorderLayout.CENTER);
		labelFields.add(fields, BorderLayout.EAST);

		gui.add(labelFields, BorderLayout.NORTH);
		Conteneur.postFrame.add(gui);
		Conteneur.postFrame.pack();
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		Conteneur.postFrame.setVisible(true);
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