package talkbot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class TesterForSystem {
	
	TalkBotSimulator tbb= new TalkBotSimulator();
	Bbody body= new Bbody(tbb.mpanel);
	
	@Test
	public void testingSimulatorGUIClickingBtns() throws InterruptedException {
		
	
		body.set1.doClick(); //checking for phrases		
		for(int i =0; i <body.track1.size();i++) {
			body.track1.get(i).doClick();
		}
		body.set2.doClick();//checking for emotions
		for(int i =0; i <body.track2.size();i++) {
			body.track2.get(i).doClick();
		} 
			 
	}

	@Test
	public void testingSimulatorGUILabels() {
		
		assertEquals("Phrases",body.set1.getText()); 
		assertEquals("Emotions",body.set2.getText());
		
		String [] track1Expect= {"Bad","First","Good","Last", "Little","Long"};
		String [] track2Expect= {"Jealous","Sad","Scared","Suprised", "Angry","Happy"};

		//test labels for each default button
		for(int i =0; i <body.track1.size();i++) {
			body.track1.get(i).doClick();
			assertEquals(track1Expect[i],body.track1.get(i).getText());
		}
		for(int i =0; i <body.track2.size();i++) {
			body.track2.get(i).doClick();
			assertEquals(track2Expect[i],body.track2.get(i).getText());
		}
				
	}
	@Test
	public void testingButtonWrongImgPath() {
		Buttons b1= new Buttons("trialButton","notRealPath",1);
		assertFalse(b1.validImgPath());	
	
	}
	
}
