package talkbot;

import java.awt.Image;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Buttons extends JButton{
	
	private ImageIcon pic;
	private String ifile;
	private int num;
	private boolean validImgPath=true;
	
	public boolean validImgPath() {
		return validImgPath;
	}
	
	public int getbtnNumber() {
		return this.num;
	}
	public Buttons (String name, String ifile, int num) {
		//Identifiers for the button
		super(name);
		this.num = num;
		this.ifile = ifile;
		try {
			this.pic = new ImageIcon(ImageIO.read(new File(ifile)).getScaledInstance(200, 230, Image.SCALE_DEFAULT));
		} catch (IOException e) {
			validImgPath=false;
			e.printStackTrace();
		}
		 
		this.setIcon(pic); //Add pic to button
	}
}
