package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest{
	
	@Test
	public void pageTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Account Login");
	}
	
	@Test
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.cssSelector("div#logo img")).isDisplayed());
	}
	

}
