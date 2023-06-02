package mytests;

import org.testng.annotations.Test;

public class EcommTest {
	
	@Test(priority = 1)
	public void loginTest() {
		System.out.println("Login Test");
	}
	
	@Test(priority=0)
	public void homeTest() {
		System.out.println("Home test");
	}
	
	@Test(priority=-1)
	public void searchTest() {
		System.out.println("Search Test");
	}
	
	@Test(priority=3)
	public void priceTest() {
		System.out.println("Price Test");
	}
	
	@Test
	public void cartTest() {
		System.out.println("Cart Test");
	}

}
