package mytests;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	@Test(invocationCount=10)
	public void test() {
		System.out.println("test method");
	}

}
