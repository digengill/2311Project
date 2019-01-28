import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TalkBoxSimulatorTest {
	
	TalkBoxSimulator tbb;

	@BeforeEach
	void setUp() throws Exception {
		tbb = new TalkBoxSimulator();
	}

	@Test
	void testTalkBoxSimulator() {
	fail("Not yet implemented");
		
	}

	@Test
	void testActionPerformed() {
		fail("Not yet implemented");
	}
	@Test
	void isButtonStringEmpty()
	{
		
		assertTrue(1,tbb.isButtonStringEmpty(1));
		
	}
}
