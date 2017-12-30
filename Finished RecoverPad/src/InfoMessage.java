import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class InfoMessage extends JFrame {
	JTextField name;
	
	 InfoMessage(String title){
         
	        super(title); //calls the window with the inputed title
	         
	        this.init(); //calls all of the extra stuff
	       //this.pack(); //makes the window change size to fit the panel
	       this.setSize(600, 300); //Sets a distinct size to the window that is not affected by the size of the panel
	        this.setVisible(true); //makes the panel visible
	    }
	
	void init()
	{
		JPanel panel = new JPanel(new BorderLayout());
		JLabel lname = new JLabel("     This is dedicated to my dad, who is constantly reminding me to save my work, even after I just did");
		JLabel hname = new JLabel("                                                                     Copyright John O'Farrell 2014");
		panel.add(lname, BorderLayout.CENTER);
		panel.add(hname, BorderLayout.SOUTH);
		this.add(panel);
	}
}