package mytests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AppTest {
	
	@BeforeSuite
	public void createUser() {
		System.out.println("BS-----Create User");
	}
	
	@BeforeTest
	public void connectWithDB() {
		System.out.println("BT------Connect Database");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC----Launch Browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BM-----Login");
	}

	@Test
	public void homePageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test
	public void searchBarTest() {
		System.out.println("Search Bar Test");
	}
	
	@Test
	public void priceTest() {
		System.out.println("Price Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM----Logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC----Close the browser");
	}
	
	@AfterTest
	public void disconnectFromDB() {
		System.out.println("AT------Disconnect from DB");
	}
	
	@AfterSuite
	public void deleteUser() {
		System.out.println("AS----Delete User");
	}

}
