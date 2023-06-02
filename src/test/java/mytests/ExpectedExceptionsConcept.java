package mytests;

import org.testng.annotations.Test;

public class ExpectedExceptionsConcept {
	
	@Test(expectedExceptions = Exception.class)
	public void loginTest() {
		System.out.println("login Test");
		int i = 9/0;
	}

}
