package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateAccountDemoCart {

	public static void main(String[] args) {
		
		// Browser setup
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
		
		//System.out.println(br.getPageTitle());
		
		//Register the User
		By registerLink = By.linkText("Register");
		
		ElementUtils eleutil = new ElementUtils(driver);
		eleutil.doClick(registerLink);
		
		By firstName = By.id("input-firstname");
		eleutil.doSendKeys(firstName, "Sath");
		
		By lastName = By.name("lastname");
		eleutil.doSendKeys(lastName, "K");
		
		By email = By.xpath("//*[@id=\"input-email\"]");
		eleutil.doSendKeys(email, "sk@gmail.com");
		
		String password = "#input-password";
		eleutil.doSendKeys("cssSelector", password, "sk@123");
		
		By newsLetter =By.xpath("//*[@id=\"input-newsletter-yes\"]");
		
		System.out.println(eleutil.doIsDisplayed(newsLetter));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", eleutil.getElement(newsLetter));
		
//		Actions actions = new Actions(driver);
//		actions.moveToElement(eleutil.getElement(newsLetter)).click().perform();
		
		eleutil.doClick(newsLetter);
		
//		By agreeCheckbox = By.cssSelector("#form-register > div > div > div > input");
//		eleutil.doClick(agreeCheckbox);
//		
//		By continueBtn = By.className("btn btn-primary");
//		eleutil.doClick(continueBtn);
//		
//		//Validate the completion of registration
//		By message = By.tagName("h1");
//		if(eleutil.doGetText(message).equals("The Account has been created Successfully")) {
//			System.out.println("The account is created");
//		}
//		else {
//			System.out.println("The account is not craeted");
//		}
		

	}

}
