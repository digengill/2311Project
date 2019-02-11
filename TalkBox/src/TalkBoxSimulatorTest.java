import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TalkBoxSimulatorTest {
	
	TalkBoxSimulator tbb;

	@BeforeEach
	void setUp() throws Exception {
		tbb = new TalkBoxSimulator();
		tbb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tbb.setTitle("Application Test");
		tbb.pack();
        tbb.setVisible(true);
	}
	@Test
	public void testOfAllButtons() throws InterruptedException{
		tbb.b1.doClick();
		tbb.b2.doClick();
		tbb.b3.doClick();
		tbb.b4.doClick();
		tbb.b5.doClick();
		tbb.b6.doClick();
	}
	
//	@Test
//	void test() {
//		TalkBoxSimulator talk1= new TalkBoxSimulator("","","","","","");
//		boolean result= talk1.isButtonStringEmpty(1);
//		
//		assertTrue(false==result);
//
//
//	}


}
