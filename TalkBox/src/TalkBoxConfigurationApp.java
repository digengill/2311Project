import java.awt.*;
import java.io.File;

import javax.swing.*;

public class TalkBoxConfigurationApp extends JFrame {

/*
	String b1Input;
	String b2Input;
	String b3Input;
	String b4Input;
	String b5Input;
	String b6Input;
	JButton b1, b2, b3, b4, b5, b6, apply;
	JTextField text1, text2, text3, text4, text5, text6;
	int x, y;
	
	TalkBoxConfigurationApp(){
		super();
		//sizevariables
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		x = screenSize.width; y = screenSize.height-120; int ratiox = x/1090, ratioy=y/1080; 
			//Buttons
		b1 = new JButton("Button 1"); b2 = new JButton("Button 2"); b3 = new JButton("Button 3"); 
		b4 = new JButton("Button 4"); b5 = new JButton("Button 5"); b6 = new JButton("Button 6");
		apply = new JButton("Apply");
			//TextFields
		text1 = new JTextField(); text2 = new JTextField(); text3 = new JTextField();
		text4 = new JTextField(); text5 = new JTextField(); text6 = new JTextField();
		
		//Set frames and pane
		JFrame frame = new JFrame();
		Container pane = new Container();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setLayout(null);
		 
		 //Add everything
			//BUTTONS
		pane.add(b1); pane.add(b2); pane.add(b3); pane.add(b4); pane.add(b5); pane.add(b6);
		pane.add(apply);
			//TEXTFIELDS
		pane.add(text1); pane.add(text2); pane.add(text3);
		pane.add(text4); pane.add(text5); pane.add(text6);
		
		//SetBounds
		b1.setBounds(10, 50, 10 + 50*ratiox, 50+75*ratioy);
		
		frame.setSize(screenSize.width, screenSize.height-120);
		frame.setVisible(true);
	}
	
	String imgName(String userButtonInput) {
		return null;
	}
	
	//method to choose button and write content for that button
	void writeToFile(String fileContent, String buttonFile) {
		File f1= new File("");
	}
	 
	 public static void main(String[] args) {
		TalkBoxConfigurationApp prac = new TalkBoxConfigurationApp();
	}
		
	TalkBoxSimulator talk1= new TalkBoxSimulator();
	TalkBoxSimulator talk2= new TalkBoxSimulator("sad","","","","","");
	TalkBoxSimulator talk3= new TalkBoxSimulator("sad","Nice","","","","");

		
	*/
	
	public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);
 
        JButton b1 = new JButton("one");
        JButton b2 = new JButton("two");
        JButton b3 = new JButton("three");
 
        pane.add(b1);
        pane.add(b2);
        pane.add(b3);
 
        Insets insets = pane.getInsets();
        Dimension size = b1.getPreferredSize();
        b1.setBounds(25 + insets.left, 5 + insets.top,
                     size.width, size.height);
        size = b2.getPreferredSize();
        b2.setBounds(55 + insets.left, 40 + insets.top,
                     size.width, size.height);
        size = b3.getPreferredSize();
        b3.setBounds(150 + insets.left, 15 + insets.top,
                     size.width + 50, size.height + 20);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("AbsoluteLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Size and display the window.
        Insets insets = frame.getInsets();
        frame.setSize(300 + insets.left + insets.right,
                      125 + insets.top + insets.bottom);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	
}
