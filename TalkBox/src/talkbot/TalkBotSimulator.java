package talkbot;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class TalkBotSimulator extends JFrame {
	
	public JPanel mpanel;
	public JPanel title, info, body;
	public JLabel tt, bd;
	public JTextArea i;
	public JFrame frame;
	Color h = new Color(0, 51, 51), n = new Color (51, 255, 255); Color b = new Color(153, 255, 255);
	
	public void setInfo() {
		info = new JPanel();
		info.setMinimumSize(new Dimension(mpanel.getWidth()-300, 200));
		info.setMaximumSize(new Dimension(mpanel.getWidth()-100, 200));
		info.setBackground(n);
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		 
		
		i = new JTextArea();
		i.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		i.setBackground(b);
		//i.setForeground(h);
		i.setLineWrap(true);
		//Read info
		File file = new File("Textfiles/info.txt");
    	try {
			Scanner scanner  = new Scanner(file);
			 while(scanner.hasNextLine()) {
	            	String line = scanner.nextLine();
	            	i.append(line); i.append("\n");
	         }
			 scanner.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	//Finish reading info
    	info.add(i);
    	//info.setVisible(true);
	}
	//153, 255, 255
	public void setTitle() {
		title = new JPanel();
		title.setLayout(new BorderLayout());
		title.setMaximumSize(new Dimension (mpanel.getWidth()-980, 100));
		title.setBackground(b);
		tt = new JLabel("Talkbox Simulator");
		tt.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		tt.setForeground(h);
		title.add(tt, BorderLayout.CENTER);
		//title.setVisible(true);

	}
	
	public void settings () {
		mpanel.setLayout(new BoxLayout(mpanel, BoxLayout.Y_AXIS));
		mpanel.setBackground(n);

		setTitle();
		setInfo();	
		body = new Bbody(mpanel);

		mpanel.add(title); //System.out.println("here1");
		//mpanel.revalidate();
		//mpanel.repaint();
		mpanel.add(info);
		mpanel.revalidate();
		mpanel.repaint();
		mpanel.add(Box.createRigidArea(new Dimension(0,15)));
		//this.revalidate();
		//this.repaint();
		mpanel.add(body);
		
	}
	
	public TalkBotSimulator() {
		//Frame Settings
		super("TalkBot Simulator");
		frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(1280, 820);
		mpanel = new JPanel();	
		//frame.setContentPane(mpanel);
		
		//System.out.println("here2");
		frame.setContentPane(mpanel);
		frame.setVisible(true);
		settings();

		//mpanel.setVisible(true);
		//this.pack();
		//this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TalkBotSimulator bot = new TalkBotSimulator(); // why isnt this used?
	}
}
