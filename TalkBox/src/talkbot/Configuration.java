package talkbot;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Configuration implements TalkBoxConfiguration{
/**
	 * 
	 */
	private static final long serialVersionUID = -2211192959370524557L;
	//PRACTICE
	private int totalbtns, aset, audiobtns;
	//audio and image
	private String rpathAfile, aname[][], rpathImage[][];
	//Buttons
	private String btname[][];
	private ArrayList<String> catnames;
	private ArrayList<ArrayList<String>> a, rpi, bn;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("serial" + File.separator + "log.bin")));

		Configuration config = new Configuration();
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
				//config.setBtnNum(12);
				config.review(2, 12);
				//AUDIO
				config.catnames=new ArrayList<String>();
				config.a = new ArrayList<ArrayList<String>>();
				config.bn = new ArrayList<ArrayList<String>>();
				config.rpi = new ArrayList<ArrayList<String>>();
				config.addcat("Phrases");
				config.addcat("Emotions");
				config.Addbtn(1, "Bad", "bad.wav", "Images"+File.separator+"bad.png");//config.setAudioName(1, 1, "bad.wav"); 
				config.Addbtn(1, "First", "first.wav", "Images"+File.separator+"1st.png");//.setAudioName(1, 2, "first.wav");
				config.Addbtn(1, "Good", "good.wav", "Images"+File.separator+"good.png");//.setAudioName(1, 3, "good.wav");
				config.Addbtn(1, "Last", "last.wav", "Images"+File.separator+"last.png");//.setAudioName(1, 4, "last.wav");
				config.Addbtn(1, "Little", "little.wav", "Images"+File.separator+"little.png");//.setAudioName(1, 5, "little.wav");
				config.Addbtn(1, "Long", "long.wav", "Images"+File.separator+"long.png");//.setAudioName(1, 6, "long.wav");
					config.Addbtn(2, "Jealous", "jealous.wav", "Images"+File.separator+"jealous.png");//.setAudioName(2, 1, "jealous.wav");
					config.Addbtn(2, "Sad", "sad.wav", "Images"+File.separator+"sad.png");//.setAudioName(2, 2, "sad.wav");
					config.Addbtn(2, "Scared", "scared.wav", "Images"+File.separator+"scared.png");//.setAudioName(2, 3, "scared.wav");
					config.Addbtn(2, "Suprised", "suprised.wav", "Images"+File.separator+"suprised.png");//.setAudioName(2, 4, "suprised.wav");
					config.Addbtn(2, "Angry", "angry.wav", "Images"+File.separator+"angry.png");//.setAudioName(2, 5, "angry.wav");
					config.Addbtn(2, "Happy", "happy.wav", "Images"+File.separator+"happy.png");//.setAudioName(2, 6, "happy.wav");
				config.setRelativePath("Audio" + File.separator);
				//Buttons
				/*config.setBtnName(1, 1, "Bad");
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
					config.setBtnName(2, 6, "Happy");*/
				config.setTotalBtnNum(14);
				//Images
				/*config.setImagePath(1, 1, "Images" + File.separator + "bad.png");
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
					config.setImagePath(2, 6, "Images" + File.separator + "happy.png");*/
					//config.Addbtn(1, "test", "Happy.wav", "Images/happy.png");
					//config.Removebtn(1, 7);
		//for (int i = 0; i < config.getSet1(); i++) {
		//	System.out.println(config.getBtnName(1, i+1));
		//}
			//config.catnames.add("Phrases"); config.catnames.add("Emotions");
				//config.addcat("Test");
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
		this.a.get(num-1).set(num-1, name);
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
	
	public void Removebtn (int set, int num) {
		set--;
		//Button Names
		this.bn.get(set).remove(num-1);
		this.btname[set] = new String [this.bn.get(set).size()];
		this.btname[set] = this.a.get(set).toArray(this.btname[set]);
		
		//Audio Names
		this.a.get(set).remove(num-1);
		this.aname[set] = new String [this.a.get(set).size()];
		this.aname[set] = this.a.get(set).toArray(this.aname[set]);
		
		//Images
		this.rpi.get(set).remove(num-1);
		this.rpathImage[set] = new String [this.rpi.get(set).size()];
		this.rpathImage[set] = this.rpi.get(set).toArray(this.rpathImage[set]);
		/*
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
		temp.remove(num-1); */
		//this.rpathImage[set] = new String [temp.size()];
		//this.rpathImage[set] = temp.toArray(this.rpathImage[set]);
		this.audiobtns--;
		this.totalbtns--;
	}
	
	public void Addbtn (int set, String bname, String audioname, String image) {
		set--;
		//Button Names
		this.bn.get(set).add(bname);
		this.btname[set] = new String [this.bn.get(set).size()];
		this.btname[set] = this.a.get(set).toArray(this.btname[set]);
		
		//Audio Names
		this.a.get(set).add(audioname);
		this.aname[set] = new String [this.a.get(set).size()];
		this.aname[set] = this.a.get(set).toArray(this.aname[set]);
		
		//Images
		this.rpi.get(set).add(image);
		this.rpathImage[set] = new String [this.rpi.get(set).size()];
		this.rpathImage[set] = this.rpi.get(set).toArray(this.rpathImage[set]);		
		/*
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
		this.rpathImage[set] = tempi.toArray(this.rpathImage[set]); */
		this.audiobtns++; this.totalbtns++;
	}
	
	//Images
	public void setImagePath (int set, int num, String path) {
		this.rpathImage[set-1][num-1] = path;
		this.rpi.get(set-1).set(num-1, path);
	}
	
	//Audio
	public void setRelativePath (String path) {
		this.rpathAfile = path;
	}
	
	public void setAudioName (int set, int num, String name) {
		//System.out.println("THe data is" +aname[0][0]);
		this.aname[set-1][num-1] = name;
		this.a.get(set-1).set(num-1, name);
	}
	
	public void review (int set, int num) {
		this.aname = new String [set][6];
		this.btname = new String [set][6];
		this.rpathImage = new String[set][6];
	}
	
	public void addcat(String name) {
		catnames.add(name);
		//this.aname[0][0] = "here";
		//System.out.println("Here      " + this.aname[0][0]);
		ArrayList<String> tempb = new ArrayList<String>();
		ArrayList<String> tempa = new ArrayList<String>();
		ArrayList<String> tempi = new ArrayList<String>();
		this.a.add(tempa); this.bn.add(tempb); this.rpi.add(tempi);
		
		//for (int i = 0; i < a.size(); i++) {
			//Button Names
			this.btname = new String [this.bn.size()][];
			//System.out.printf("[%d][%d]\n", this.bn.size(), this.bn.get(i).size());
			//Audio Names
			this.aname = new String [this.a.size()][];
			//Images
			this.rpathImage = new String [this.rpi.size()][];
			//System.out.println(this.btname[i][0] + "\n");
			
		//}
		
		for (int i = 0; i < this.a.size(); i++) {
			//Map values to array 
			System.out.println(a.size());
			//Button Names
			this.btname[i] = new String [this.bn.get(i).size()];
			this.btname[i] = this.a.get(i).toArray(this.btname[i]);
			//Audio Names
			this.aname[i] = new String [this.a.get(i).size()];
			this.aname[i] = this.a.get(i).toArray(this.aname[i]);
			//Images
			this.rpathImage[i] = new String [this.rpi.get(i).size()];
			this.rpathImage[i] = this.rpi.get(i).toArray(this.rpathImage[i]);	

			//}
		}		

		this.aset++;
	} 
	
	public void removecat(String name) {
		int num = catnames.indexOf(name);
		catnames.remove(name);
		this.a.remove(num); this.bn.remove(num);  this.rpi.remove(num);
				
		for (int i = 0; i < a.size(); i++) {
			//Button Names
			this.btname = new String [this.bn.size()][this.bn.get(i).size()];
			//Audio Names
			this.aname = new String [this.a.size()][this.a.get(i).size()];
			//Images
			this.rpathImage = new String [this.rpi.size()][this.rpi.get(i).size()];
		}
		
		//Map values to array
		this.btname = this.bn.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);//this.a.toArray(this.btname);
		this.aname = this.a.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);//this.a.toArray(this.aname);
		this.rpathImage = this.rpi.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);//.toArray(this.rpathImage);
		
		this.aset--;
	}

//	protected void removeSetAt(int location)
//	{
////		aname[location]= null;
////		rpathImage[location] = null;
////		btname[location] = null;
//		for(int i = 0; i < 6; i++)
//		{
//			try
//			{
//				Removebtn(location, i);
//			}
//			catch(IndexOutOfBoundsException E)
//			{
//				System.out.println("out of bounds");
//			}
//		}
//	}
//	protected void addSetAt(int location, String name)
//	{
//		aname[location][0] = name;
//	}

	public String getcatNames (int num) {
		for (int i = 0; i < catnames.size(); i++) {
			System.out.println(catnames.get(i));
		}
		return this.catnames.get(num);
	}
}
