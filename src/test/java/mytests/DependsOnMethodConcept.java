package mytests;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	@Test
	public void loginTest() {
		System.out.println("Login test");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods = "searchzTest")
	public void homePageTest(){
		System.out.println("Home Page test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("Search Test");
		
	}

}
