package talkbot;
  
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
public class SystemTester1 {
	TalkBotSimulator tbb= new TalkBotSimulator();
	Bbody body= new Bbody(tbb.mpanel);
	
	
	
	//Test the buttons on the simulator GUI, update how its done in the document
	@Test
	public void testingSimulatorGUIClickingBtns() throws InterruptedException {
		
		body.categories.get(0).doClick();
		body.categories.get(1).doClick();
		
		for(int i =0; i <body.tbuttons.get(0).size();i++) {
			body.tbuttons.get(0).get(i).doClick();
		}
	
		for(int i =0; i <body.tbuttons.get(1).size();i++) {
			body.tbuttons.get(1).get(i).doClick();
		}
  
	}

	
	
	
	
	@Test
	public void testingSimulatorGUILabels() {
		
		
		assertEquals("Phrases",body.categories.get(0));
		assertEquals("Emotions",body.categories.get(1));
		//hrtr
		String [] track1Expect= {"Bad","First","Good","Last", "Little","Long"};
		String [] track2Expect= {"Jealous","Sad","Scared","Suprised", "Angry","Happy"};

		//test labels for each default button
//		for(int i =0; i <body.track1.size();i++) {
//			body.track1.get(i).doClick();
//			assertEquals(track1Expect[i],body.track1.get(i).getText());
//		}
//		for(int i =0; i <body.track2.size();i++) {
//			body.track2.get(i).doClick();
//			assertEquals(track2Expect[i],body.track2.get(i).getText());
//		}
			
	}
	//This werkjwekw
	
	
	
//	@Test
//	public void testingButtonWrongImgPath() {
//		Buttons b1= new Buttons("trialButton","notRealPath",12);
//		assertFalse(b1.validImgPath());	
//	}

	@Test
	public void testConfiguration() {
		Configuration config = new Configuration();
		
		config.setAudioSets(0);
		config.setBtnNum(0);
		config.review(2, 12);
		
		config.setArrList();
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
		
		/*
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
		*/
		config.setTotalBtnNum(14);
		//Images
		config.setImagePath(1, 1, "Images"+File.separator+"bad.png");
		config.setImagePath(1, 2, "Images"+File.separator+"1st.png");
		config.setImagePath(1, 3, "Images"+File.separator+"good.png");
		config.setImagePath(1, 4, "Images"+File.separator+"last.png");
		config.setImagePath(1, 5, "Images"+File.separator+"little.png");
		config.setImagePath(1, 6, "Images"+File.separator+"long.png");
		
		config.setImagePath(2, 1, "Images"+File.separator+"jealous.png");
		config.setImagePath(2, 2, "Images"+File.separator+"sad.png");
		config.setImagePath(2, 3, "Images"+File.separator+"scared.png");
		config.setImagePath(2, 4, "Images"+File.separator+"suprised.png");
		config.setImagePath(2, 5, "Images"+File.separator+"angry.png");
		config.setImagePath(2, 6, "Images"+File.separator+"happy.png");

		
		
		assertEquals(12,config.getNumberOfAudioButtons());//there are 12 audio buttons
		assertEquals(14,config.getTotalNumberOfButtons()); //12 audio button + 2 category buttons
		
		//testing setAudioName ;	
		String[][] audioFileNamesExpected= {
			{"bad.wav","first.wav","good.wav","last.wav","little.wav","long.wav"},
			{"jealous.wav","sad.wav","scared.wav","suprised.wav","angry.wav","happy.wav"}
			};
		String[][]result=config.getAudioFileNames();
		for(int i =0; i <result.length;i++) {
			for(int j=0; j<result[i].length;j++) {
				assertEquals(audioFileNamesExpected[i][j],result[i][j]);
			}
		}
		//testing setBtnName and getSet1Button/getSet2Button
		String [] set1BtnNames= {"Bad","First","Good","Last","Little","Long"};
		String [] set2BtnNames= {"Jealous","Sad","Scared","Suprised","Angry","Happy"};
		
		
		
		
		for(int i =0; i <config.getSet1();i++) {
			assertEquals(set1BtnNames[i],(config.getSet1Buttons()[i]));
		}
		
		for(int i =0; i <config.getSet2();i++) {
			assertEquals(set2BtnNames[i],(config.getSet2Buttons()[i]));
		}

		
		config.Removebtn(1,6);
		//when button removed test that it's no longer in  the set btname
		String [] set1NewBtnNames= {"Bad","First","Good","Last","Little"};
		 
		for(int i =0; i <config.getSet1();i++) {
			assertEquals(set1NewBtnNames[i],(config.getSet1Buttons()[i]));
		}
		
		String[][] audioFileNamesExpectedNew= {
				{"bad.wav","first.wav","good.wav","last.wav","little.wav"},
				{"jealous.wav","sad.wav","scared.wav","suprised.wav","angry.wav","happy.wav"}
				};
		//when button removed test that it's no longer in  the set aset, i.e audio files name set
		String[][] removedResult=config.getAudioFileNames();
		for(int i =0; i <removedResult.length;i++) {
			for(int j=0; j<removedResult[i].length;j++) {
				assertEquals(audioFileNamesExpected[i][j],removedResult[i][j]);
			}
		}
		
		config.Addbtn(1, "Long", "long.wav", "Images/long.png");
		
		//when a button added, test that it's in  the set btname in the correct index
		for(int i =0; i <config.getSet1();i++) {
			assertEquals(set1BtnNames[i],(config.getSet1Buttons()[i]));
			System.out.println(config.getSet1Buttons()[i]);
		}
		
		System.out.println("Start here 2:\n\n\n");
		//when button added, test that it is longer in  the set aset, i.e audio files name set
		String[][]addResult=config.getAudioFileNames();
		for(int i =0; i <addResult.length;i++) {
			for(int j=0; j<addResult[i].length;j++) {
				System.out.println(addResult[i][j]);
				assertEquals(audioFileNamesExpected[i][j],addResult[i][j]);
			}
		}
		
		
		// Remove category at to doc
		
		
		
		
	}
	
	
	@Test
	public void TalkBoxConfigurationTest() {
		TalkBoxConfigurationGUI configGui=new TalkBoxConfigurationGUI();
		
		
		/*
		
		configGui.add.doClick();
//		configGui.remove.doClick();
		configGui.change.doClick();
//		configGui.changeAudio.doClick(); //doing this test will lauch j file chooser which 
//		configGui.changeImage.doClick();
		
		configGui.Apply.doClick();
//		configGui.nameEnter.doClick();
		configGui.audioPreview.doClick();
		
//		configGui.addButton.doClick();
//		configGui.removeButton.doClick();
		
//		configGui.ab.doClick(); 
//		configGui.rb.doClick();
		
		configGui.addButton();
		configGui.removeButton();
//		configGui.actionPerformed(null);
 * 
 * */ 
 
	}
	
	
}
