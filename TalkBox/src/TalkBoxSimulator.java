import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.applet.*;
public class TalkBoxSimulator extends JFrame implements ActionListener {

int maxX, maxY;
Dimension buttonSpacing;	
JPanel centerPanel;
JPanel centerPaneltop;
JPanel centerPanelbottom;
JPanel mainPanel;
JPanel westPanel;

JPanel eastPanel;
JPanel panel1Top;
JPanel panel2;

JButton b1;
JButton b2;
JButton b3;
JButton b4;
JButton b5;
JButton b6;
JButton b7;

JLabel l1;
JLabel l2;
JLabel l3;
JLabel l4;
JLabel l5;
JLabel l6;

BufferedImage p1;
BufferedImage p2;
BufferedImage p3;
BufferedImage p4;
BufferedImage p5;
BufferedImage p6;

JButton north, west, east, south, center;


/**
 * Default constructor. Initializes the buttons based on preset choices
  */ 
public TalkBoxSimulator ()
{
	this("Happy","Sad","Angry","Hungry","Washroom","Done");

}

public TalkBoxSimulator (String button1,String button2,String button3,String button4, String button5, String button6)
{
	super("TalkBox");
	this.setMinimumSize(new Dimension(500,400));
    this.setExtendedState(MAXIMIZED_BOTH);

	
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
    // JPanel initialization
    mainPanel = new JPanel();
    centerPanel = new JPanel();
    centerPaneltop = new JPanel();
    centerPanelbottom = new JPanel();
    westPanel = new JPanel();
    eastPanel = new JPanel();
    
    b1 = new JButton(button1);
    b2 = new JButton(button2);
    b3 = new JButton(button3);
    b4 = new JButton(button4);
    b5 = new JButton(button5);
    b6 = new JButton(button6);
    

    l1 = new JLabel(button1);
    l2 = new JLabel(button2);
    l3 = new JLabel(button3);
    l4 = new JLabel(button4);
    l5 = new JLabel(button5);
    l6 = new JLabel(button6);

    buttonSpacing = new Dimension(60,60);
    
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    
    //Panel Layout
    centerPanelbottom.add(b1);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(b2);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(b3);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(b4);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(b5);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(b6);
    
    centerPaneltop.add(l1);
    centerPaneltop.add(l2);
    centerPaneltop.add(l3);
    centerPaneltop.add(l4);
    centerPaneltop.add(l5);
    centerPaneltop.add(l6);
   


    
    mainPanel.add(l1,BorderLayout.WEST);

    centerPanelbottom.setBackground(Color.CYAN);
    
    mainPanel.setLayout(new BorderLayout());
    centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
    centerPaneltop.setLayout(new BoxLayout(centerPaneltop,BoxLayout.X_AXIS));
    centerPanelbottom.setLayout(new BoxLayout(centerPanelbottom,BoxLayout.X_AXIS));

    centerPanel.add(centerPaneltop);
    centerPanel.add(centerPanelbottom);
    mainPanel.add(centerPanel,BorderLayout.CENTER);
    
    
    setContentPane(mainPanel);

	
}









//Methods for Simulator

public boolean isButtonStringEmpty(int buttonNumber ) {
	if(buttonNumber==1) {
		return !(b1.getText().equals(""));
	}
	else if(buttonNumber==2) {
		return !(b2.getText().equals(""));
	}
	else if(buttonNumber==3) {
		return !(b3.getText().equals(""));
	}
	else if(buttonNumber==4) {
		return !(b4.getText().equals(""));
	}
	else if(buttonNumber==5) {
		return !(b5.getText().equals(""));
	}else if(buttonNumber==6) {
		return !(b6.getText().equals(""));
	}
	else {
		System.out.println("Error: Invalid Argument");
		return false;
	}
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
		
		

	}

}
