package talkbot;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Configuration implements TalkBoxConfiguration{
//PRACTICE
	private int totalbtns, aset, audiobtns;
	//audio and image
	private String rpathAfile, aname[][], rpathImage[][];
	//Buttons
	private String btname[][];
	protected String[] setNames;
	private static Configuration config;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("serial" + File.separator + "log.bin")));

		//Configuration 
		config = new Configuration();
		//Test1 before sets
		/*
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
		*/
		//Test2 with sets added
		//Get numbers
				
				//config.setAudioSets(2);
		        config.aset = 2;
				config.setBtnNum(12);
				config.review(config.getNumberOfAudioSets(), config.getNumberOfAudioButtons());
				//AUDIO
				config.setAudioName(1, 1, "bad.wav");
				config.setAudioName(1, 2, "first.wav");
				config.setAudioName(1, 3, "good.wav");
				config.setAudioName(1, 4, "last.wav");
				config.setAudioName(1, 5, "little.wav");
				config.setAudioName(1, 6, "long.wav");
					config.setAudioName(2, 1, "jealous.wav");
					config.setAudioName(2, 2, "sad.wav");
					config.setAudioName(2, 3, "scared.wav");
					config.setAudioName(2, 4, "suprised.wav");
					config.setAudioName(2, 5, "angry.wav");
					config.setAudioName(2, 6, "happy.wav");
				config.setRelativePath("Audio" + File.separator);
				//Buttons
				config.setBtnName(1, 1, "Bad");
				config.setBtnName(1, 2, "First");
				config.setBtnName(1, 3, "Good");
				config.setBtnName(1, 4, "Last");
				config.setBtnName(1, 5, "Little");
				config.setBtnName(1, 6, "Long");
					config.setBtnName(2, 1, "Jealous");
					config.setBtnName(2, 2, "Sad");
					config.setBtnName(2, 3, "Scared");
					config.setBtnName(2, 4, "Suprised");
					config.setBtnName(2, 5, "Angry");
					config.setBtnName(2, 6, "Happy");
				config.setTotalBtnNum(14);
				//Images
				config.setImagePath(1, 1, "Images" + File.separator + "bad.png");
				config.setImagePath(1, 2, "Images" + File.separator + "1st.png");
				config.setImagePath(1, 3, "Images"+ File.separator +"good.png");
				config.setImagePath(1, 4, "Images" + File.separator + "last.png");
				config.setImagePath(1, 5, "Images" + File.separator + "little.png");
				config.setImagePath(1, 6, "Images" + File.separator + "long.png");
					config.setImagePath(2, 1, "Images" + File.separator + "jealous.png");
					config.setImagePath(2, 2, "Images" + File.separator + "sad.png");
					config.setImagePath(2, 3, "Images" + File.separator + "scared.png");
					config.setImagePath(2, 4, "Images" + File.separator + "suprised.png");
					config.setImagePath(2, 5, "Images" + File.separator + "angry.png");
					config.setImagePath(2, 6, "Images" + File.separator + "happy.png");
					//config.Addbtn(1, "test", "Happy.wav", "Images/happy.png");
					//config.Removebtn(1, 7);
		//for (int i = 0; i < config.getSet1(); i++) {
		//	System.out.println(config.getBtnName(1, i+1));
		//}
					
					config.setSetName(0, "Phrases");
					config.setSetName(1, "Emotions");
//					System.out.println(config.getSetName(0));
//					System.out.println(config.getSetName(1));
					
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
	
	public int getSet1 () {
		return this.btname[0].length;
	}
	
	public int getSet2 () {
		return this.btname[1].length;
	}
	/**
	 * gets the set length at the given location
	 * 
	 * @param location
	 * @return
	 */
	public int getSetAt(int location)
	{
		return this.btname[location].length;
	}
	
	public String [] getSet1Buttons () {
		return this.btname[0];
	}
	
	public String [] getSet2Buttons () {
		return this.btname[1];
	}
	/**returns the buttons at the set specified by location
	 * note location 0 is the first spot in the array
	 * 
	 * @param location
	 * @return
	 */
	public String [] getSetButtonsAt(int location) {
		return this.btname[location];
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
	
//	public void setAudioSets (int num) {
//		this.aset = num;
//	}
	
	public void Removebtn (int set, int num) {
		set--;
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < this.btname[set].length; i++) {
			temp.add(btname[set][i]);
		}
		temp.remove(num-1);
		this.btname[set] = new String [temp.size()];
		this.btname[set] = temp.toArray(this.btname[set]);
		temp = new ArrayList<String>();
		
		for (int i = 0; i < this.aname[set].length; i++) {
			temp.add(aname[set][i]);
		}
		temp.remove(num-1);
		this.aname[set] = new String [temp.size()];
		this.aname[set] = temp.toArray(this.aname[set]);
		temp = new ArrayList<String>();
		
		for (int i = 0; i < this.rpathImage[set].length; i++) {
			temp.add(rpathImage[set][i]);
		}
		temp.remove(num-1);
		this.rpathImage[set] = new String [temp.size()];
		this.rpathImage[set] = temp.toArray(this.rpathImage[set]);
		this.audiobtns--;
		this.totalbtns--;
	}
	
	public void Addbtn (int set, String bname, String audioname, String image) {
		set--;
		ArrayList<String> tempb = new ArrayList<String>();
		ArrayList<String> tempa = new ArrayList<String>();
		ArrayList<String> tempi = new ArrayList<String>();
		for (int i = 0; i < aname[set].length; i++) {
			tempb.add(this.btname[set][i]);
			tempa.add(this.aname[set][i]);
			tempi.add(this.rpathImage[set][i]);
		}
		tempb.add(bname); tempa.add(audioname); tempi.add(image);
		
		this.btname[set] = new String [tempb.size()];
		this.btname[set] = tempb.toArray(this.btname[set]);
		
		this.aname[set] = new String [tempa.size()];
		this.aname[set] = tempa.toArray(this.aname[set]);
		this.rpathImage[set] = new String [tempi.size()];
		this.rpathImage[set] = tempi.toArray(this.rpathImage[set]);
		this.audiobtns++; this.totalbtns++;
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
		this.aname = new String [set][6];
		this.btname = new String [set][6];
		this.rpathImage = new String[set][6];
		this.setNames = new String[set];
	}

	protected void removeSetAt(int location)
	{
		
		setNames[location] = null;
		for(int i = 0; i < 1000; i++)
		{
			try
			{
				
				Removebtn(location, i);
				System.out.println("Button removed");
			}
			catch(IndexOutOfBoundsException E)
			{
				System.out.println("Removal out of bounds");
				//E.printStackTrace();
			}
		}
	}
	
	protected String getSetName(int index)
	{
		return setNames[index];
	}

	protected void setSetName(int set, String name)
	{
		try
		{
			setNames[set] = name;
		}
		catch(Exception E)
		{
			System.out.println(set);
			E.printStackTrace();
		}
		
	}
	protected void addSet(String name)
	{
	 setNumberPlusOne();

		for(int i = 0; i < getNumberOfAudioSets(); i++)
		{
			if (getSetName(i) == null)
			{
				setSetName(i, name);
				System.out.println(name + " " + getSetName(i) + " " + i + " " + getNumberOfAudioSets());
				break;
			}
		}
		//System.out.println(getSetName(2));
	}
	public void setNumberPlusOne() 
	{
		int set = getNumberOfAudioSets();
		String[][] tempAudio = new String[set + 1][];
		String[][] tempButtonName= new String[set + 1][];
		String[][] tempImage = new String[set + 1][];		
		String[] tempSetName = new String[set + 1];
		
		for(int i = 0; i < setNames.length; i++)
		{
			//for(int j = 0; j )
			tempAudio[i] = aname[i];
			tempButtonName[i] = btname[i];
			tempImage[i] = rpathImage[i];
			tempSetName[i] = setNames[i];
		}
		//System.out.println(aname.length + " " + tempAudio.length);
		aname = tempAudio;
		btname = tempButtonName;
		rpathImage = tempImage;
		setNames = tempSetName;
		//System.out.println(aname.length + " " + tempAudio.length);
		aset++;
	}
	
//	protected void addSetAt(int location, String name)
//	{
//		try 
//		{
//			btname[location][0] = name;
//			System.out.println(name);
//		}
//		catch(IndexOutOfBoundsException E)
//		{
//			System.out.println("New out of bounds");
//			E.printStackTrace();
//		}
//	}

}
