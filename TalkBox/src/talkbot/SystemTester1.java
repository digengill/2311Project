package talkbot;
  
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SystemTester1 {
	TalkBotSimulator tbb= new TalkBotSimulator();
	Bbody body= new Bbody(tbb.mpanel);
	
	
	//Test the buttons on the simulator GUI, update how its done in the document
	@Test
	public void testingSimulatorGUIClickingBtns() throws InterruptedException {
		TalkBotSimulator tbb2= new TalkBotSimulator();
		Bbody body2= new Bbody(tbb2.mpanel);
		
		
		body2.categories.get(0).doClick();
		body2.categories.get(1).doClick();
		
		
		body2.tbuttons.get(1).get(4).doClick();
		//only works until 2!, same array problem with satinder
		//		body2.tbuttons.get(2).get(0).doClick();
//		for(int i =1; i <body2.tbuttons.get(0).size()-1;i++) {
//			body2.tbuttons.get(1).get(i).doClick();
//		}
//	
//		for(int i =1; i <body2.tbuttons.get(1).size()-1;i++) {
//			body2.tbuttons.get(2).get(i).doClick();
//		}
  
	}

	
	
	
	
	@Test
	public void testingSimulatorGUILabels() {
		
		
		assertEquals("Phrases",body.categories.get(0).getText());
		assertEquals("Emotions",body.categories.get(1).getText());
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
	
	
	
	
	@Test
	public void testingButtonWrongImgPath() {
		Buttons b1= new Buttons("trialButton","notRealPath",12);
		assertFalse(b1.validImgPath());	
	}

	
	
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
		
//		config.setBtnName(1, 3, "Good");
//		config.setBtnName(1, 4, "Last");
//		config.setBtnName(1, 5, "Little");
//		config.setBtnName(1, 6, "Long");
//		config.setBtnName(2, 1, "Jealous");
//		config.setBtnName(2, 2, "Sad");
//		config.setBtnName(2, 3, "Scared");
//		config.setBtnName(2, 4, "Suprised");
//		config.setBtnName(2, 5, "Angry");
//		config.setBtnName(2, 6, "Happy");
		
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
			//System.out.println(config.getSet1Buttons()[i]);
		}
		
	//	System.out.println("Start here 2:\n\n\n");
		//when button added, test that it is longer in  the set aset, i.e audio files name set
		String[][]addResult=config.getAudioFileNames();
		for(int i =0; i <addResult.length;i++) {
			for(int j=0; j<addResult[i].length;j++) {
			//	System.out.println(addResult[i][j]);
				assertEquals(audioFileNamesExpected[i][j],addResult[i][j]);
			}
		}
		
		//ADDDDDDD TO DOC
		//test the number of buttons in a category
		assertTrue(config.getSetButtonsAt(1).length==6);
		
		
		// Remove category TO DOC
		config.removecat("Phrases");
		assertTrue(config.catnames.size()==1);
	}
	
	
	
	
	
	//	JButton changeAudio, changeImage, Apply, nameEnter, audioPreview, addButton, removeButton, changeButton, addButtonSave,removeButtonSave, back;
	//	JButton addAudio, addImage, catagories;
	//  JButton simLog;
	
	
	//JTextField btnName, btnName2;
	
	//JComboBox chooseButton;
	//JComboBox<String> chooseSet, chooseSetMain;
	//
	
	@Test
	public void TalkBoxConfigurationGUITest() {
		TalkBoxConfigurationGUI configGui=new TalkBoxConfigurationGUI();
		
		//add button option 
		configGui.addButton.doClick();
		configGui.addButtonSave.doClick();
		configGui.back.doClick();
		
		//remove button option 
		configGui.removeButton.doClick();
		//configGui.removeButtonSave.doClick();
		configGui.back.doClick();
		
		
		//change button option 
		configGui.changeButton.doClick();
		configGui.back.doClick();
		
		//category button option 
		configGui.catagories.doClick();
		configGui.back.doClick();
		
		configGui.AddSet.doClick();
		
		configGui.RemoveSet.doClick();
		configGui.back.doClick();

		//log GUI from Configurator test
		configGui.simLog.doClick();
		
		
		

 
	}
	
	
}
