package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {
	
	@Test
	public void pageTitleTest() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Sign Up for a Free HR Software Trial | OrangeHRM | OrangeHRM");
	}
	
	@Test
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='OrangeHRM Logo']")).isDisplayed());
	}
	
	@Test
	private void platformTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Platform")).isDisplayed());
	}

}
