import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class OpenSave extends JFrame implements ActionListener{
	public int nameAmount= 200;
	JRadioButton openProj, newSave;
	JTextField name;
	JButton clear;
	 OpenSave(){
         
	        super("Select Workspace"); //calls the window with the inputed title
	         
	        this.init(); //calls all of the extra stuff
	       this.pack(); //makes the window change size to fit the panel
	       //this.setSize(1000, 100); //Sets a distinct size to the window that is not affected by the size of the panel
	        this.setVisible(true); //makes the panel visible
	    }
	
	void init()
	{
		JPanel panel = new JPanel(new GridLayout(3,1));
		JLabel lname = new JLabel("Select what to work on:");
		openProj = new JRadioButton("Open an existing project ");
		newSave = new JRadioButton("Create a new project");
		openProj.addActionListener(this);
		newSave.addActionListener(this);
		
		ButtonGroup groupGender = new ButtonGroup(); //creates a group of buttons. This is like a panel, but for buttons
		groupGender.add(openProj); //adds the buttons to the button group. Since they're all in the same group, you can only choose one. 
		groupGender.add(newSave);
		 
		panel.add(lname);
		panel.add(openProj);
		panel.add(newSave);
		this.add(panel);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if(e.getSource() == openProj)
			{
				nameAmount = 50;
				
			}
			
			if(e.getSource() == newSave)
			{
				nameAmount = 150;
			}
	}

}
