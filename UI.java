// The graphical userinterface

package all_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends Serielist{
	
	JLabel Name, Season, State, RenewDate;
	JTextField NameField, SeasonField, StateField, RenewDateField;
	JTextArea textArea;
	JButton Add;
	JPanel thePanel;
	JScrollPane scrollbar;
	
	void listPrinter() {
		for(Serie s : listOfseries) {
			textArea.append(s.toString());
			textArea.append("\n");
		}
	}
		
	public UI() throws Exception{
		
		thePanel = new JPanel();
		JFrame Xframe = new JFrame("TV Status");
		Xframe.setLayout(new FlowLayout());
		Xframe.setSize(1500, 900);
		Xframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Xframe.setResizable(true);
		Xframe.add(thePanel);
				
		Name = new JLabel("Name"); 				NameField = new JTextField("serie name", 14);			
		Season = new JLabel("Season"); 			SeasonField = new JTextField("0", 14);
		State = new JLabel("State"); 			StateField = new JTextField("serie state", 14);
		RenewDate = new JLabel("RenewDate"); 	RenewDateField = new JTextField("serie renew date", 14);
		
		Add = new JButton("Add");
		ListenForButton lForButton = new ListenForButton();
		Add.addActionListener(lForButton);
		
		textArea = new JTextArea(10, 20);
		scrollbar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		textArea.setLineWrap(true);
		
		thePanel.add(Name);						thePanel.add(NameField);
		thePanel.add(Season);					thePanel.add(SeasonField);
		thePanel.add(State);					thePanel.add(StateField);
		thePanel.add(RenewDate);				thePanel.add(RenewDateField);
		thePanel.add(Add);
		thePanel.add(textArea);
		thePanel.add(scrollbar);
		
		Xframe.setVisible(true);
		listPrinter();
	}
	
	private class ListenForButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == Add) {
				try {
					if(!NameField.getText().equals("serie name")) addSerieToList(NameField.getText(), Integer.parseInt(SeasonField.getText()), StateField.getText(), RenewDateField.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				textArea.setText("");
				listPrinter();
				
			}
		}
	}
}


