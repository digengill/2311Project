package talkbot;

import java.awt.Image;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Buttons extends JButton{
	
	private ImageIcon pic;
	private String imageFile;
	private int num;
	private boolean validImgPath=true;
	
	public boolean validImgPath() {
		return validImgPath;
	}
	
	public int getbtnNumber() {
		return this.num;
	}
	public Buttons (String name, String iFile, int num) {
		//Identifiers for the button
		super(name);
		this.num = num;
		this.imageFile = iFile;
		try {
			this.pic = new ImageIcon(ImageIO.read(new File(iFile)).getScaledInstance(200, 230, Image.SCALE_DEFAULT));
		} catch (IOException e) {
			validImgPath=false;
			e.printStackTrace();
		}
		 
		this.setIcon(pic); //Add pic to button
	}
//	@Override
//	public String getName()
//	{
//		return this.getName();
//	}
}
