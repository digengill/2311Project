package talkbot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.*;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TBCLog {

	public TBCLog()
	{
		JFrame frame = new JFrame("Log");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextArea text = new JTextArea(10,10);
		File fname = new File("Textfiles/info.txt");
		try {
	          BufferedReader input = new BufferedReader(new InputStreamReader(
	              new FileInputStream(fname)));
	          text.read(input, "READING FILE :-)");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
		 frame.getContentPane().add(text, BorderLayout.CENTER);
		 frame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.NORTH);
		 frame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.SOUTH);
		 frame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.EAST);
		 frame.getContentPane().add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.WEST);
		 frame.getContentPane().setBackground(Color.blue);

		 frame.pack();
		 frame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TBCLog test = new TBCLog();
		
	}

}
