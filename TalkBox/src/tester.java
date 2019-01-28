import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class tester {

	@Test
	void test() {
		TalkBoxSimulator talk1= new TalkBoxSimulator("","","","","","");
		boolean result= talk1.isButtonStringEmpty(1);
		
		assertTrue(false==result);
		
	}

}
