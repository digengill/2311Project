import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.applet.*;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;

public class TalkBoxSimulator extends JFrame implements ActionListener {

Dimension buttonSpacing;
Dimension labelSpacing;
Dimension buttonSize;
JPanel centerPanel;
JPanel centerPaneltop;
JPanel centerPanelbottom;
JPanel mainPanel;
JPanel westPanel;
JPanel northPanel;
JPanel southPanel;
JPanel eastPanel;
JPanel panel1Top;
JPanel panel2;
JButton b1, b2, b3, b4, b5, b6, configureButton;

JLabel l1, l2, l3, l4, l5, l6;

ImageIcon pic1, pic2, pic3, pic4, pic5, pic6;
JButton north, west, east, south, center;
AudioClip play1;
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
    
	final JFXPanel fxPanel = new JFXPanel();

	
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
    northPanel.setPreferredSize(new Dimension(100,200));
   // southPanel.setPreferredSize(new Dimension(100,200));

    b1 = new JButton(button1);
    b2 = new JButton(button2);
    b3 = new JButton(button3);
    b4 = new JButton(button4);
    b5 = new JButton(button5);
    b6 = new JButton(button6);
    configureButton = new JButton("Configure");

    l1 = new JLabel();
    l2 = new JLabel();
    l3 = new JLabel();
    l4 = new JLabel();
    l5 = new JLabel();
    l6 = new JLabel();
    
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
    setImage(l1,pic1,"happy1.png");
    setImage(l2,pic2,"sad.png");
    setImage(l3,pic3,"angry.png");
    setImage(l4,pic4,"hungry.png");
    setImage(l5,pic5,"washroom.png");
    setImage(l6,pic6,"happy1.png");

    

    buttonSize = new Dimension(50,130);
    buttonSpacing = new Dimension(50,60);
    labelSpacing = new Dimension(100,100);
    
    

    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    configureButton.addActionListener(this);
    
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
   
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(Box.createRigidArea(new Dimension(100,10)));
    southPanel.add(configureButton);
    
    
    centerPaneltop.setBackground(Color.GRAY);
    northPanel.setBackground(Color.ORANGE);
    southPanel.setBackground(Color.ORANGE);
    centerPanelbottom.setBackground(Color.CYAN);
    
    
    mainPanel.setLayout(new BorderLayout());
    centerPanel.setLayout(new GridLayout(2,1));
    centerPaneltop.setLayout(new GridLayout(1,11));
    centerPanelbottom.setLayout(new GridLayout(1,11));
    southPanel.setLayout(new GridLayout(2,3));
    
    
    centerPanel.add(centerPaneltop);
    centerPanel.add(centerPanelbottom);
    
    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(centerPanel,BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);
    
    setContentPane(mainPanel);

	
}


public void setImage(JLabel l, ImageIcon icon, String imageName)
{
	icon.setImage(new ImageIcon(imageName).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	l.setIcon(icon);



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
	if (source == configureButton)
	{
		TalkBoxConfigurationApp prac = new TalkBoxConfigurationApp();
		
	}
}
	
	
	
	public static void main(String[] args) {
		TalkBoxSimulator test = new TalkBoxSimulator();
		test.setVisible(true);
		test.pack();
		

	}

}
