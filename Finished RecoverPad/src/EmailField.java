import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmailField extends JFrame implements ActionListener{
	JTextField name;
	private JButton send;
	
	 EmailField(){
         
	        super("Email Field"); 
	         
	        this.init(); //calls all of the extra stuff
	       //this.pack(); //makes the window change size to fit the panel
	       this.setSize(500, 100); //Sets a distinct size to the window that is not affected by the size of the panel
	        this.setVisible(true); //makes the panel visible
	    }
	
	void init()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel lname = new JLabel("Please enter your email address here: ");
		JTextField txtName = new JTextField(20);
		send = new JButton("Send");
		send.addActionListener(this);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL; 
		
		c.gridx = 0; //The x and y refer to rows and columns, respectively. Java will figure out the amount of rows and columns by itself 
		c.gridy = 0;
		panel.add(lname,c);
		
		c.gridx = 1;
		panel.add(txtName, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		panel.add(send, c);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubif(txtName.readLine() != null)
		JOptionPane.showMessageDialog(this, "Your email has been sent");
	}
}