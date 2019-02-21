import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.applet.*;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;

public class TalkBoxSimulator extends JFrame implements ActionListener {

Dimension buttonSpacing;
Dimension labelSpacing;
Dimension buttonSize;
ArrayList<JButton> buttonArray;
ArrayList buttonName;
ArrayList<JLabel> labelName;
JPanel centerPanel;
JPanel centerPaneltop;
JPanel centerPanelbottom;
JPanel newButtons, newLabels, newConfigButtons, newConfigLabels;
JPanel mainPanel;
JPanel westPanel;
JPanel northPanel;
JPanel southPanel;
JPanel eastPanel;
JPanel panel1Top;
JPanel panel2;
JButton b1, b2, b3, b4, b5, b6, configureButton;
JButton cb1, cb2, cb3, cb4, cb5, cb6;
JButton pb1, pb2, pb3, pb4, pb5, pb6;
JLabel l1, l2, l3, l4, l5, l6;
JButton addButton;
ImageIcon pic1, pic2, pic3, pic4, pic5, pic6;
AudioClip play1;
/**
 * Default constructor. Initializes the buttons based on preset choices
  */ 
public TalkBoxSimulator()
{
	this(false);
}
public TalkBoxSimulator (Boolean custom)
{
	this(6,custom,"Happy","Sad","Angry","Hungry","Washroom","Done");
	
}

public TalkBoxSimulator (int numOfButtons,Boolean custom, String button1,String button2,String button3,String button4, String button5, String button6)
{
	super("TalkBox");
	this.setMinimumSize(new Dimension(500,400));
    
	final JFXPanel fxPanel = new JFXPanel();

	buttonArray = new ArrayList<JButton>();
	buttonArray.add(b1);
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
    // JPanel initialization
    mainPanel = new JPanel();
    centerPanel = new JPanel();
    centerPaneltop = new JPanel();
    centerPanelbottom = new JPanel();
    westPanel = new JPanel();
    eastPanel = new JPanel();
    northPanel = new JPanel();
    southPanel = new JPanel();
    northPanel.setPreferredSize(new Dimension(10,100));
   southPanel.setPreferredSize(new Dimension(100,200));

    b1 = new JButton(button1);
    b2 = new JButton(button2);
    b3 = new JButton(button3);
    b4 = new JButton(button4);
    b5 = new JButton(button5);
    b6 = new JButton(button6);
    
    addButton = new JButton("Add Button");
    
    cb1 = new JButton("Change Audio 1");
    cb2 = new JButton("Change Audio 2");
    cb3 = new JButton("Change Audio 3");
    cb4 = new JButton("Change Audio 4");
    cb5 = new JButton("Change Audio 5");
    cb6 = new JButton("Change Audio 6");
    
    pb1 = new JButton("Change Picture 1");
    pb2 = new JButton("Change Picture 2");
    pb3 = new JButton("Change Picture 3");
    pb4 = new JButton("Change Picture 4");
    pb5 = new JButton("Change Picture 5");
    pb6 = new JButton("Change Picture 6");
    
    
    cb1.setVisible(custom);
    cb2.setVisible(custom);
    cb3.setVisible(custom);
    cb4.setVisible(custom);
    cb5.setVisible(custom);
    cb6.setVisible(custom);
    
    pb1.setVisible(custom);
    pb2.setVisible(custom);
    pb3.setVisible(custom);
    pb4.setVisible(custom);
    pb5.setVisible(custom);
    pb6.setVisible(custom);
    
    
   
    
    l1 = new JLabel();
    l2 = new JLabel();
    l3 = new JLabel();
    l4 = new JLabel();
    l5 = new JLabel();
    l6 = new JLabel();
    
    labelName = new ArrayList<JLabel>();
	labelName.add(l1);
	labelName.add(l2);
	labelName.add(l3);
	labelName.add(l4);
	labelName.add(l5);
	labelName.add(l6);
    
    newButtons = new JPanel();
    newLabels = new JPanel();
    newConfigButtons = new JPanel();
    newConfigLabels = new JPanel();
    
    pic1 = new ImageIcon();
    pic2 = new ImageIcon();
    pic3 = new ImageIcon();
    pic4 = new ImageIcon();
    pic5 = new ImageIcon();
    pic6 = new ImageIcon();
try {
    play1 = Applet.newAudioClip(new File("wavtest.wav").toURI().toURL());

}
 catch(Exception e)
{
	 
	 }
    setImage(l1,"happy1.png");
    setImage(l2,"sad.png");
    setImage(l3,"angry.png");
    setImage(l4,"hungry.png");
    setImage(l5,"washroom.png");
    setImage(l6,"happy1.png");

    

    buttonSize = new Dimension(50,130);
    buttonSpacing = new Dimension(50,60);
    labelSpacing = new Dimension(100,100);
    
    

    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    //configureButton.addActionListener(this);
    addButton.addActionListener(this);
    
    cb1.addActionListener(this);
    cb2.addActionListener(this);
    cb3.addActionListener(this);
    cb4.addActionListener(this);
    cb5.addActionListener(this);
    cb6.addActionListener(this);
    
    
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
    
    centerPanelbottom.add(cb1);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(cb2);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(cb3);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(cb4);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(cb5);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(cb6);
    
    centerPanelbottom.add(pb1);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(pb2);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(pb3);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(pb4);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(pb5);
    centerPanelbottom.add(Box.createRigidArea(buttonSpacing));
    centerPanelbottom.add(pb6);
    
    
    centerPaneltop.add(l1);
    centerPaneltop.add(Box.createRigidArea(labelSpacing));
    centerPaneltop.add(l2);
    centerPaneltop.add(Box.createRigidArea(labelSpacing));
    centerPaneltop.add(l3);
    centerPaneltop.add(Box.createRigidArea(labelSpacing));
    centerPaneltop.add(l4);
    centerPaneltop.add(Box.createRigidArea(labelSpacing));
    centerPaneltop.add(l5);
    centerPaneltop.add(Box.createRigidArea(labelSpacing));
    centerPaneltop.add(l6);
   
    southPanel.add(addButton);
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    
    
    centerPaneltop.setBackground(Color.GRAY);
    northPanel.setBackground(Color.ORANGE);
    southPanel.setBackground(Color.ORANGE);
    centerPanelbottom.setBackground(Color.CYAN);
    
    
    mainPanel.setLayout(new BorderLayout());
    centerPanel.setLayout(new GridLayout(3,1));
    centerPaneltop.setLayout(new GridLayout(1,11));
    centerPanelbottom.setLayout(new GridLayout(3,11));
    southPanel.setLayout(new GridLayout(2,3));
    
    
 
   
   
    centerPanel.add(centerPaneltop);
    centerPanel.add(centerPanelbottom);
   // centerPanel.add(newLabels);
    //centerPanel.add(newLabels);
    //centerPanel.add(newConfigButtons);
   // centerPanel.add(newConfigLabels);
    
    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(centerPanel,BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);
    
    setContentPane(mainPanel);

	
}


public void setImage(JLabel l, String path)
{
	l.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

	//l.setIcon(new ImageIcon(path));
	//icon.setImage(new ImageIcon(path).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	//l.setIcon(icon);



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
			//SpeakerClass talk = new SpeakerClass("btn1.txt");
			play1.play();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	else if (source == b2)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn2.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	else if (source == b3)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn3.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	else if (source == b4)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn4.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	else if (source == b5)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn5.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	else if (source == b6)
	{
		try {
			SpeakerClass talk = new SpeakerClass("btn6.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if (source == configureButton)
	{
		TalkBoxConfigurationApp prac = new TalkBoxConfigurationApp();
		
	}
	else if (source == addButton)
	{
		
		
		
	}
}
	
	
	
	public static void main(String[] args) {
		TalkBoxSimulator test = new TalkBoxSimulator(false);
		test.setVisible(true);
		test.pack();
		

	}

}
