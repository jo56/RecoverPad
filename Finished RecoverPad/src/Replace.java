import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Replace extends JFrame implements ActionListener{
	JTextField name;
	private JButton replace;
	public String thingsToReplace;
	public String replaceWith1;
	 Replace(){
         
	        super("Replace"); 
	         
	        this.init(); //calls all of the extra stuff
	       this.pack(); //makes the window change size to fit the panel
	       //this.setSize(500, 100); //Sets a distinct size to the window that is not affected by the size of the panel
	        this.setVisible(true); //makes the panel visible
	    }
	
	void init()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel lname = new JLabel("Words to replace: ");
		JLabel bname = new JLabel("Replace with: ");
		JTextField toReplace = new JTextField(15);
		JTextField replaceWith = new JTextField(15);
		replace = new JButton("Replace");
		replace.addActionListener(this);
		GridBagConstraints c = new GridBagConstraints();
		thingsToReplace = JOptionPane.showInputDialog("Please enter what you want to replace");
		replaceWith1 = JOptionPane.showInputDialog("Please enter what you want to replace it with");
		
		
		/*c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0; //The x and y refer to rows and columns, respectively. Java will figure out the amount of rows and columns by itself 
		c.gridy = 0;
		panel.add(lname,c);
		
		c.gridx = 1;
		panel.add(toReplace, c);
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(bname, c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(replaceWith, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		panel.add(replace, c);
		this.add(panel); */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubif(txtName.readLine() != null)
		
		
	}
}