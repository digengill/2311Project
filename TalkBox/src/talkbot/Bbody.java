package talkbot;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import sun.audio.*;

public class Bbody extends JPanel implements ActionListener {
	
	private JPanel sp;
	private JScrollPane scroll;
	private Configuration con;
	private ObjectInputStream in;
	
	public void setup(JPanel mpanel) {
		sp = new JPanel();
		sp.setMinimumSize(new Dimension(this.getWidth(), 300));
		sp.setMaximumSize(new Dimension(this.getWidth(), 300));
		sp.setBackground(new Color(255, 204, 209));
		
		sp.setLayout(new FlowLayout());
	}
	
	public void setbtns() {//
		for (int i = 0; i < con.getNumberOfAudioButtons(); i++) {System.out.println(con.getPathToImageFile(1, i+1));
			Buttons btn = new Buttons(con.getBtnName(1, i+1), con.getPathToImageFile(1, i+1), i+1);
			btn.addActionListener(this);
			sp.add(btn);
			this.revalidate();
			this.repaint();
			//////////////////////MAYBE SURROUND WITH TRY CATCH
		}
	}
	
	public Bbody (JPanel mpanel) {
		super();
		//Read in serialized file
		try {
			
			in = new ObjectInputStream(new FileInputStream("serial/log.bin"));
			con = (Configuration) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setMinimumSize(new Dimension(mpanel.getWidth()-50, 300));
		this.setMaximumSize(new Dimension(mpanel.getWidth()-50, 300));
		this.setBackground(new Color (0, 12, 25));
		this.setLayout(new FlowLayout());
				
		this.setup(mpanel);
		
		//Set scroll features
		scroll = new JScrollPane(sp);
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(mpanel.getWidth()-100, 270));
		//scroll.setMinimumSize(new Dimension(400, this.getHeight()));
		//scroll.setMaximumSize(new Dimension(400, this.getHeight()));
		//sp.add(scroll);		
			this.setbtns();
			this.add(scroll);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().getClass().equals(talkbot.Buttons.class)) {
			Buttons temp = (Buttons) e.getSource();
			String tempath = this.con.getPathToAudioFile(1, temp.getbtnNumber());
			playSound(tempath);
		}
	}
	
	public void playSound(String temp) {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(temp));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception e) {
	        System.out.println("Error with sound.");
	        e.printStackTrace();
	    }
	}

}
