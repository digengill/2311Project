import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
public class TalkBoxSimulator extends JFrame implements ActionListener {
	
JPanel panel1;
JPanel mainPanel;
JPanel topPanel;
JPanel panel1Center;
JPanel panel1Top;
JPanel panel2;

JButton b1;
JButton b2;
JButton b3;
JButton b4;
JButton b5;
JButton b6;
JButton b7;
//File audioclip = new File("");

/**
 * Default constructor. Initializes the buttons based on preset choices
  */ 
public TalkBoxSimulator ()
{
	super("TalkBox");
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    this.setExtendedState(MAXIMIZED_BOTH);
    
    // JPanel initialization
    mainPanel = new JPanel();
    panel1 = new JPanel();
    panel2 = new JPanel();
    topPanel = new JPanel();
    panel1Center = new JPanel();
    panel1Top = new JPanel();
    panel1Center = new JPanel();
    
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
    
    //Panel Layout
    panel1.setLayout(new BorderLayout());
    mainPanel.setLayout( new BorderLayout());
    
   // Panel Size
    panel1Center.setSize(200, 200);
    panel1Top.setPreferredSize(new Dimension(50,50));
    topPanel.setPreferredSize(new Dimension(50,50));
    
    
   // Panel Color
    panel1.setBackground(Color.gray);
    panel2.setBackground(Color.CYAN);
    topPanel.setBackground(Color.ORANGE);
    panel1Center.setBackground(Color.black);
    
    
    
    //Panel ADD
    
    panel1Center.add(b1);
    panel1Center.add(b2);
    
    panel1.add(panel1Center, BorderLayout.CENTER);
    panel1.add(panel1Top, BorderLayout.NORTH);
    
    mainPanel.add(panel2,BorderLayout.CENTER);
    mainPanel.add(panel1, BorderLayout.WEST);
    mainPanel.add(topPanel,BorderLayout.NORTH);
    
    setContentPane(mainPanel);

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
		test.pack();
		test.setVisible(true);
		
		

	}

}
