package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		br.getPageTitle();
		br.getUrl();
		
		ElementUtils el = new ElementUtils(driver);
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		el.doSendKeys(emailId, "sk@gmail.com");
		el.doSendKeys(password, "test@123");
		
		
		//br.closeBrower();

	}

}
