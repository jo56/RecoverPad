import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

 
public class Notepad extends JFrame implements ActionListener, ItemListener, CaretListener{
 
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuAbout;
	private JMenu menuFormat;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem exit;
	private JMenuItem copy;
	private JMenuItem goodSave;
	private JMenuItem New;
	private JMenuItem paste;
	private JMenuItem info;
	private JMenuItem email;
	private JMenuItem cut;
	private JMenuItem replace;
	private JMenuItem delete;
	private JMenuItem help;
	private JMenuItem time;
	private JMenuItem selectAll;
	private JMenuItem font;
	private JCheckBox wrapText;
	private JTextArea page;
	String opSave;
	String fontType;
	
	boolean autoSave = false;
	boolean breakOpen = false;
	File fileName;
	
Notepad(){
 
super("RecoverPad");
init();
this.setSize(600, 400);
this.setVisible(true);
 
}
private void init(){
	
	
	page = new JTextArea();
	menuFile = new JMenu("File");
	menuEdit = new JMenu("Edit");
	menuFormat = new JMenu("Format");
	menuAbout = new JMenu("About");
	 
	
	page.setSize(600, 400);
	
	//create menu items
	open = new JMenuItem("Open");
	save = new JMenuItem("Save As");
	exit = new JMenuItem("Exit");
	copy = new JMenuItem("Copy");
	paste = new JMenuItem("Paste");
	New = new JMenuItem("New");
	info = new JMenuItem("Info");
	cut = new JMenuItem("Cut");
	email = new JMenuItem("Email");
	replace = new JMenuItem("Replace");
	delete = new JMenuItem("Delete");
	help = new JMenuItem("Help");
	time = new JMenuItem("Time/Date");
	selectAll = new JMenuItem("Select All");
	goodSave = new JMenuItem("Save");
	font = new JMenuItem("Font");
	wrapText = new JCheckBox("Wrap Text");
	wrapText.setSelected(false);
	
	
	
	exit.addActionListener(this);
	copy.addActionListener(this);
	paste.addActionListener(this);
	info.addActionListener(this);
	New.addActionListener(this);
	save.addActionListener(this);
	goodSave.addActionListener(this);
	open.addActionListener(this);
	cut.addActionListener(this);
	email.addActionListener(this);
	replace.addActionListener(this);
	delete.addActionListener(this);
	help.addActionListener(this);
	time.addActionListener(this);
	selectAll.addActionListener(this);
	font.addActionListener(this);
	wrapText.addItemListener(this);
	page.addCaretListener(this);
	
	//add items to menus
	menuFile.add(New);
	menuFile.add(open);
	menuFile.add(goodSave);
	menuFile.add(save);
	menuFile.add(exit);
	//menuFile.add(email);
	menuEdit.add(copy);
	menuEdit.add(paste);
	menuEdit.add(cut);
	menuEdit.add(replace);
	menuEdit.add(delete);
	menuEdit.add(selectAll);
	menuEdit.add(time);
	menuFormat.add(wrapText);
	menuFormat.add(font);
	menuAbout.add(info);
	menuAbout.add(help);
	
	
	 
	//create menu bar
	menuBar = new JMenuBar();
	 
	//adds menus to the bar
	menuBar.add(menuFile);
	menuBar.add(menuEdit);
	menuBar.add(menuFormat);
	menuBar.add(menuAbout);
	 
	 
	//add menu bar to the window
	this.setJMenuBar(menuBar);
	this.add(page);
	
	
	autoSave = true;
	while(breakOpen == false){
opSave = (String)JOptionPane.showInputDialog("Would you like to start a new project or open an existing one?");
	
	if(opSave.equals("open") || opSave.equals("Open") || opSave.equals("open project") || opSave.equals("Open project"))
	{
		this.openFile();
	}
	
	else
	{
		this.saveFile();
	}
	 
	}
	}

void openFile(){
	 
JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //creates an instance of FileChooser and makes it so that it will only select files)
 
int result = fileChooser.showOpenDialog(this); //stores an integer result, in this case from the button pressed in the show open dialogue
 
if(result == JFileChooser.CANCEL_OPTION){
return; //detects that the button cancel has been chosen, and 
} 

fileName = fileChooser.getSelectedFile(); //the selected file is stored as file "filename"


if (fileName == null || fileName.getName().equals("")){ //if the file name doesn't exist
JOptionPane.showMessageDialog(this, "Invalid File Name", "This is an" + " invalid file name.", JOptionPane.ERROR_MESSAGE);
}//end if
 
else{
	breakOpen = true;
BufferedReader input;
try{
input = new BufferedReader(new FileReader(fileName.getAbsolutePath())); //sets it up for reading 
String line;
int lineCount = 0;


while((line = input.readLine()) != null) //reads the line of text, assigns it to line. 
{
	
page.append(line+"\n"); //while there is text in that line, it attaches the text to page, while including a line break. This line is what actually maes the opened text appear
	
	lineCount++;
}//end while

if(lineCount >= 60)
{
	page.append("\nThis text is property of John O'Farrell. Copyright 2014");
}
input.close();
}//end try
catch(Exception e){
JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
}//end catch
}//end else
}

private void saveFile(){
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
     
    int result = fileChooser.showSaveDialog(this);
     
    if(result == JFileChooser.CANCEL_OPTION) 
    return;
     
    fileName = fileChooser.getSelectedFile(); 
     
    if (fileName == null || fileName.getName().equals("")){ 
        JOptionPane.showMessageDialog(this, "Invalid File Name", "This is an" + " invalid file name.", JOptionPane.ERROR_MESSAGE); //up to here, same thing as open
    }//end if
    else{
    	breakOpen = true;
        BufferedWriter output;
        try{
            output = new BufferedWriter(new FileWriter(fileName.getAbsolutePath()));
            output.write(page.getText(), 0, page.getText().length()); // the function that writes the file. Has three arguments: the text, a 0 (which indicates what character to start writing the text, and the length of the text to write. Lrngth is (.getlength - x), with x being equal to the second number 
            output.close();
        }//end try
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error", e.toString(), JOptionPane.ERROR_MESSAGE);
        }//end catch
    }
}

private void betterSave(){
	if (fileName == null || fileName.getName().equals("")){ 
        JOptionPane.showMessageDialog(this, "Invalid File Name", "This is an" + " invalid file name.", JOptionPane.ERROR_MESSAGE); //up to here, same thing as open
    }//end if
    else{
        BufferedWriter output;
        try{
            output = new BufferedWriter(new FileWriter(fileName.getAbsolutePath()));
            output.write(page.getText(), 0, page.getText().length()); // the function that writes the file. Has three arguments: the text, a 0 (which indicates what character to start writing the text, and the length of the text to write. Lrngth is (.getlength - x), with x being equal to the second number 
            output.close();
        }//end try
        catch(Exception e1){
            JOptionPane.showMessageDialog(this, "Error", e1.toString(), JOptionPane.ERROR_MESSAGE);
        }//end catch
    }
}
@Override

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	  if (e.getSource() == exit){
          this.dispose();
      }//end if
	  
      else if (e.getSource() == copy){
          page.copy();
      }//end else if
	  
      else if (e.getSource() == paste){
          page.paste();
      }
	  
      else if(e.getSource() == info){
	InfoMessage notepad = new InfoMessage("About");
	notepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
	  
      else if (e.getSource() == New){
          page.setText("");
         
      }
	  
      else if (e.getSource() == time){
    	  DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss MM/dd/YYYY");
          Date date = new Date();
          page.append(" " +dateFormat.format(date));
          
      }
	  
      else if (e.getSource() == cut){
          page.cut();
      }
	  
      else if (e.getSource() == selectAll){
          
    	  page.selectAll();
      }
	  
      else if(e.getSource() == email){
    	  EmailField simpleWin = new EmailField();
          simpleWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      }
	  
      else if(e.getSource() == replace){
    	  String replaceWith1 = JOptionPane.showInputDialog("Please enter what you want to replace the selected text with");
          page.replaceSelection(replaceWith1);
      }
	  
      else if (e.getSource() == save){
          this.saveFile();
          autoSave = true;
      }
	  
      else if (e.getSource() == goodSave){
    	  this.betterSave();
      }
	  
	  
      else if (e.getSource() == delete){
    	  page.replaceSelection("");
      }
      else if (e.getSource() == help){
    	  JOptionPane.showMessageDialog(this, "There is none");
      }
	  
      else if (e.getSource() == font){
    	  try{
              fontType = (String)JOptionPane.showInputDialog("What type of font do you want?");
              Font font = new Font(fontType, Font.PLAIN, 12);
              page.setFont(font);
              }
              
              catch(Exception af){
            	  JOptionPane.showMessageDialog(this, "You entered an invalid type");
              }
      }
	  
      else {
    	  this.openFile();
      }
	
}
@Override
public void itemStateChanged(ItemEvent ae) {
	// TODO Auto-generated method stub
	
	
	if(wrapText.isSelected() == true){
		page.setLineWrap(true);  
		page.setWrapStyleWord(true);
	}
	
	else{
		page.setLineWrap(false);  
		page.setWrapStyleWord(false);
	}
	
}
@Override
public void caretUpdate(CaretEvent arg0)
{
	try{if(autoSave == true){
    this.betterSave();
	}
	}
	catch(Exception af)
	{
		
	}
}


}
