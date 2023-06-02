package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTestBM {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	}
	
	@Test(priority = 1)
	public void logoTest() {
		Boolean flag = driver.findElement(By.xpath("//img[@alt='OrangeHRM Logo']")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4)
	public void platformLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Platform")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Sign Up for a Free HR Software Trial | OrangeHRM | OrangeHRM");
	}
	
	@Test(priority = 3)
	public void headerTest() {
		String header = driver.findElement(By.cssSelector("div.free-trial-page-slider-content h1")).getText();
		System.out.println(header);
		Assert.assertTrue(header.contains("free trial"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
	

}
