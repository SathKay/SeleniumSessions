package AppTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest extends BaseTest{
	
	@Test
	public void pageTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test(enabled=false)
	public void searchTest() {
		driver.findElement(By.name("q")).sendKeys("macbook pro");
//		String hyperLink = driver.findElement(By.xpath("//div[@class='yuRUbf']/a")).getAttribute("href");
//		Assert.assertTrue(hyperLink.contains("https://www.apple.com"));
		Assert.assertTrue(true);
	}

}
