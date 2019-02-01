import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
public class TalkBoxSimulator extends JFrame implements ActionListener {
JPanel panel1;
JButton b1;
JButton b2;
JButton b3;
JButton b4;
JButton b5;
JButton b6;
JButton b7;


/**
 * Default constructor. Initializes the buttons based on preset choices
  */ 
public TalkBoxSimulator ()
{
	
	super("TalkBox");
	setSize(720, 600);
	setLayout(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    panel1 = new JPanel();
    panel1.setBounds(150, 100, 500, 500);
    b1 = new JButton("Happy");
    b2 = new JButton("Sad");
    b3 = new JButton("Angry");
    b4 = new JButton("Hungry");
    b5 = new JButton("Washroom");
    b6 = new JButton("Done");
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    
    panel1.setBackground(Color.gray);
    panel1.setLayout(new FlowLayout());
    panel1.add(b1);
    panel1.add(b2);
    panel1.add(b3);
    panel1.add(b4);
    panel1.add(b5);
    panel1.add(b6);
    
    setContentPane(panel1);

}

public TalkBoxSimulator (String button1,String button2,String button3,String button4, String button5, String button6)
{
	
	super("TalkBox");
	setSize(720, 600);
	setLayout(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    panel1 = new JPanel();
    panel1.setBounds(150, 100, 500, 500);
   
    //initialize buttons based on Strings
    b1 = new JButton(button1);
    b2 = new JButton(button2);
    b3 = new JButton(button3);
    b4 = new JButton(button4);
    b5 = new JButton(button5);
    b6 = new JButton(button6);
    
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    
    panel1.setBackground(Color.gray);
    panel1.setLayout(new FlowLayout());
    panel1.add(b1);
    panel1.add(b2);
    panel1.add(b3);
    panel1.add(b4);
    panel1.add(b5);
    panel1.add(b6);
    
    setContentPane(panel1);

}












public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	if (source == b1)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn1.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if (source == b2)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn2.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if (source == b3)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn3.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if (source == b4)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn4.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if (source == b5)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn5.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if (source == b6)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn6.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
	
	
	
	public static void main(String[] args) {
		TalkBoxSimulator test = new TalkBoxSimulator();
		test.setVisible(true);
		test.pack();

	}

}
