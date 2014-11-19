package tpdev.actions;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tpdev.listeners.VoteListener;

public class Response {

	
	public Response () {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		Conteneur.responseFrame = new JFrame("Results");
		Conteneur.responseFrame.setSize(300, 500);
		Conteneur.responseFrame.setContentPane(panel);
		
		Conteneur.responseArea = new JTextArea();
		Conteneur.responseScroll = new JScrollPane(Conteneur.responseArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Conteneur.responseScroll.setBounds(10, 10, 250, 250);
		Conteneur.responseArea.setEditable(false);
		Conteneur.responseArea.setEnabled(true);
		
		Conteneur.noterLabel = new JLabel("Donnez une note !");
		Conteneur.noterLabel.setBounds(10, 270, 150, 30);
		Conteneur.idSnippetLabel = new JLabel("Id snippet : ");
		Conteneur.idSnippetLabel.setBounds(10, 310, 90, 30);
		Conteneur.idSnippetField = new JTextField();
		Conteneur.idSnippetField.setBounds(100, 310, 30, 30);
		Conteneur.noteLabel = new JLabel("Note : ");
		Conteneur.noteLabel.setBounds(10, 350, 90, 30);
		
		Conteneur.pourRadio = new JRadioButton("Pour");
		Conteneur.contreRadio = new JRadioButton("Contre");
		Conteneur.groupePourContreRadio = new ButtonGroup();
		Conteneur.groupePourContreRadio.add(Conteneur.pourRadio);
		Conteneur.groupePourContreRadio.add(Conteneur.contreRadio);
		Conteneur.pourRadio.setSelected(true);
		Conteneur.pourRadio.setBounds(110, 350, 80, 40);
		Conteneur.contreRadio.setBounds(200, 350, 80, 40);
		
		Conteneur.noterButton = new JButton("Noter");
		Conteneur.noterButton.setBounds(10, 390, 80, 30);
		Conteneur.noterButton.addActionListener(new VoteListener());
		
		Conteneur.infoResponseLabel = new JLabel();
		Conteneur.infoResponseLabel.setBounds(10, 440, 240, 30);
		
		panel.add(Conteneur.responseScroll);
		panel.add(Conteneur.noterLabel);
		panel.add(Conteneur.idSnippetLabel);
		panel.add(Conteneur.idSnippetField);
		panel.add(Conteneur.noteLabel);
		panel.add(Conteneur.pourRadio);
		panel.add(Conteneur.contreRadio);
		panel.add(Conteneur.noterButton);
		panel.add(Conteneur.infoResponseLabel);
		
		Conteneur.responseFrame.setVisible(true);
	}
	
	public void setText (String text) {
		Conteneur.responseArea.setText("");
		Conteneur.responseArea.append(text);
	}
	
}
