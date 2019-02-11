import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TalkBoxConfigurationAppTest {

	TalkBoxConfigurationApp config;

	@BeforeEach
	void setUp() throws Exception {
		config = new TalkBoxConfigurationApp();
		config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		config.setTitle("Configuration Test Run");
		config.pack();
		config.setVisible(true);
	}
	@Test
	public void testClickingButtons() throws InterruptedException{
        Thread.sleep(1000);
        config.apply.doClick();
	}
	public void testingIfTextFieldCanBeWriten() {
//		Must use JTextField just set inside each string field and see if you can write to it 
//		Class Example:
//		frame.name.setText("Bil");
//        assertEquals(frame.name.getText(),"Bil");

	}
	

}
