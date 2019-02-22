package talkbot;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Configuration implements TalkBoxConfiguration{
//PRACTICE
	private int totalbtns, aset, audiobtns;
	//audio and image
	private String rpathAfile, aname[][], rpathImage[][];
	//Buttons
	private String btname[][];
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("serial/log.bin")));

		Configuration config = new Configuration();
		//Get numbers
		config.setAudioSets(1);
		config.setBtnNum(6);
		config.review(config.getNumberOfAudioSets(), config.getNumberOfAudioButtons());
		//AUDIO
		config.setAudioName(1, 1, "bad.wav");
		config.setAudioName(1, 2, "first.wav");
		config.setAudioName(1, 3, "good.wav");
		config.setAudioName(1, 4, "last.wav");
		config.setAudioName(1, 5, "little.wav");
		config.setAudioName(1, 6, "long.wav");
		config.setRelativePath("Audio/");
		//Buttons
		config.setBtnName(1, 1, "Bad");
		config.setBtnName(1, 2, "First");
		config.setBtnName(1, 3, "Good");
		config.setBtnName(1, 4, "Last");
		config.setBtnName(1, 5, "Little");
		config.setBtnName(1, 6, "Long");
		config.setTotalBtnNum(6);
		//Images
		config.setImagePath(1, 1, "Images/bad.png");
		config.setImagePath(1, 2, "Images/1st.png");
		config.setImagePath(1, 3, "Images/good.png");
		config.setImagePath(1, 4, "Images/last.png");
		config.setImagePath(1, 5, "Images/little.png");
		config.setImagePath(1, 6, "Images/long.png");
		
		obj.writeObject(config);
		obj.close();
	}

	@Override
	public int getNumberOfAudioButtons() {
		// TODO Auto-generated method stub
		return audiobtns;
	}

	@Override
	public int getNumberOfAudioSets() {
		// TODO Auto-generated method stub
		return aset;
	}

	@Override
	public int getTotalNumberOfButtons() {
		// TODO Auto-generated method stub
		return totalbtns;
	}

	@Override
	public Path getRelativePathToAudioFiles() {
		// TODO Auto-generated method stub
		return Paths.get(this.rpathAfile);
	}
	
	

	@Override
	public String[][] getAudioFileNames() {
		// TODO Auto-generated method stub
		return aname;
	}
	///////////////////////////Personal methods//////////////////////////
	public String getPathToAudioFile (int set, int btn) {
		return (this.rpathAfile + aname[set-1][btn-1]);
	}
	
	public String getPathToImageFile (int set, int btn) {
		return (this.rpathImage[set-1][btn-1]);
	}
	
	public String getBtnName (int set, int num) {
		return this.btname [set-1][num-1];
	}
	
	//Button sets
	public void setBtnName (int set, int num, String name) {
		this.btname[set-1][num-1] = name;
	}
	
	public void setBtnNum (int num) {
		this.audiobtns = num;
	}
	
	public void setTotalBtnNum (int num) {
		this.totalbtns = num;
	}
	
	public void setAudioSets (int num) {
		this.aset = num;
	}
	
	//Images
	public void setImagePath (int set, int num, String path) {
		this.rpathImage[set-1][num-1] = path;
	}
	
	//Audio
	public void setRelativePath (String path) {
		this.rpathAfile = path;
	}
	
	public void setAudioName (int set, int num, String name) {
		this.aname[set-1][num-1] = name;
	}
	
	public void review (int set, int num) {
		this.aname = new String [set][num];
		this.btname = new String [set][num];
		this.rpathImage = new String[set][num];
	}


}
