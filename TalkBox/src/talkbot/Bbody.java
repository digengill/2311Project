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
import java.util.ArrayList;

import sun.audio.*;

public class Bbody extends JPanel implements ActionListener {
	
	
	//req
	private JPanel sp;
	private JScrollPane scroll;
	protected Configuration con;
	private ObjectInputStream in;
	public JButton set1, set2;
	public ArrayList<Buttons> track1, track2;
	private Boolean on, play=false;
	private Clip clip;
	 
	
	public void setup(JPanel mpanel) {
		sp = new JPanel();
		sp.setMinimumSize(new Dimension(this.getWidth(), 300));
		sp.setMaximumSize(new Dimension(this.getWidth(), 300));
		sp.setBackground(new Color(255, 204, 209));
		sp.setLayout(new FlowLayout());
	}
	
	public void sets() {
		set1 = new JButton("Phrases");
		set2 = new JButton("Emotions");
		this.add(set1);
		this.add(set2);
		set1.addActionListener(this);
		set2.addActionListener(this);
	}
	
	public void setbtns() {//
		track1 = new ArrayList<Buttons>();
		track2 = new ArrayList<Buttons>(); on=true;
		for (int h = 0; h < 2; h++) {
			if (h==0) { //System.out.println(con.getSet1());
				for (int i = 0; i < con.getSet1(); i++) {
					//System.out.println(con.getPathToImageFile(1, i+1)); System.out.println(i);
					Buttons btn = new Buttons(con.getBtnName(1, i+1), con.getPathToImageFile(1, i+1), i+1);
					btn.addActionListener(this);
					track1.add(btn);
					sp.add(track1.get(i));
					this.revalidate();
					this.repaint();
					//////////////////////MAYBE SURROUND WITH TRY CATCH
				}
			} else if (h==1) {
				for (int i = 0; i < con.getSet2(); i++) {//System.out.println(con.getPathToImageFile(2, i+1));
					Buttons btn = new Buttons(con.getBtnName(2, i+1), con.getPathToImageFile(2, i+1), i+1);
					//btn.addActionListener(this);
					track2.add(btn);
					sp.add(track2.get(i));
					track2.get(i).setVisible(false);
					//////////////////////MAYBE SURROUND WITH TRY CATCH
				}
			}
		}
		this.revalidate(); this.repaint();
			
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
		this.setMinimumSize(new Dimension(mpanel.getWidth()-50, 400));
		this.setMaximumSize(new Dimension(mpanel.getWidth()-50, 400));
		this.setBackground(new Color (0, 12, 25));
		this.setLayout(new FlowLayout());
				
		this.setup(mpanel);
		this.sets();
		//Set scroll features
		scroll = new JScrollPane(sp);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
		if (e.getSource().getClass().equals(talkbot.Buttons.class)) { int bn;
			if (on)
				bn=1;
			else
				bn=2;
			Buttons temp = (Buttons) e.getSource(); 
			String tempath = this.con.getPathToAudioFile(bn, temp.getbtnNumber());
			playSound(tempath);
		} else if (e.getSource()==set1 && on==false) {
			for (int i = 0; i < track2.size(); i++) {
				//track2.get(i).setVisible(false); 
				sp.remove(track2.get(i));
			}
			on=true;
			for (int i = 0; i < track1.size(); i++) {
				//track1.get(i).setVisible(true); 
				sp.add(track1.get(i));
				track1.get(i).addActionListener(this);
			} 
			this.revalidate(); this.repaint();
		} else if (e.getSource()==set2 && on==true) {
			for (int i = 0; i < track1.size(); i++) {
				//track1.get(i).setVisible(false); track1.get(i).removeActionListener(this);
				sp.remove(track1.get(i));
				track1.get(i).removeActionListener(this);
			} on=false;
			for (int i = 0; i < track2.size(); i++) {
				sp.add(track2.get(i));
				track2.get(i).setVisible(true);
				track2.get(i).addActionListener(this);
			} this.revalidate(); this.repaint();
		}
	}
	
	public void playSound(String temp) {
	    try {
	       // Clip clip = AudioSystem.getClip();
	        
	        if (play==false) {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(temp));
	        	clip = AudioSystem.getClip();
	        	clip.open(audioInputStream);
	        	clip.start();
	        	play=true;
	        }
	        else {
	        	clip.stop();
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(temp));
	        	clip = AudioSystem.getClip();
	        	clip.open(audioInputStream);
	        	clip.start();
	        }
	    } catch(Exception e) {
	       // System.out.println("Error with sound.");
	        e.printStackTrace();
	    }
	}

}
