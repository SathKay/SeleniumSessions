package seleniumsessions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EleUtilPractice {
	
	private WebDriver driver;
	
	//findElement
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	//sendkeys
	public void doSendKeys(By locator, String value) {
		 getElement(locator).sendKeys(value);
	}
	
	//click
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	//getText
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	//getAttribute
	public String doGetAttributeValue(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}
	
	//isDisplayed
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	//findElements
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	//findElements count
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	//print elements text
	public void printElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for(WebElement e: eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
	}
	
	//return the list of text from elements
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList= getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	
	//return list of text from Elements using conventional for loop
	public List<String> getElementsTextListByForLoop(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(int i=0;i<eleList.size();i++) {
			String text = eleList.get(i).getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	
	//return elements attribute list
	public List<String> getElementsAttributeList(By locator, String aatributeName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttributeList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String value = e.getAttribute(aatributeName);
			eleAttributeList.add(value);
		}
		return eleAttributeList;
	}
	
	//click on text
	public void clickOnText(By locator, String textValue) {
		List<WebElement> eleList = getElements(locator);
		for(WebElement e: eleList) {
			String text = e.getText();
			if(text.equals(textValue)) {
				e.click();
				break;
			}
		}
		
	}
	
	//select suggestion from search box
	public void slectSuggestion(By locator, String suggestion) {
		List<WebElement> suggList = getElements(locator);
		for(WebElement e: suggList) {
			String text = e.getText();
			if(text.equals(suggestion)) {
				e.click();
				break;
			}
		}
	}
	
	/*------------------------------Select DropDown-------------------------------------*/
	
	//select drop down by index
	public void selectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	//select drop down by Visible Text
	public void selectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	//select drop down by Value
	public void selectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	//Get the options count
	public int getOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	
	//get the select options text
	public List<String> getOptionsText(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for(WebElement e: optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	
	//select dropdown using its text
	public void selectDropDownByText(By locator, String textValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e: optionsList) {
			String text = e.getText();
			if(text.equals(textValue)) {
				e.click();
				break;
			}
		}
		
	}
	
	/******************************Actions Method****************************/
	
	//sendKeys using Actions
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	//click using actions
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	/************************************Waits***********************************/
	
	// Wait for Element Presence
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Wait for Element Visibility
	public WebElement waitforElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//Wait for Element to be enabled to click
	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//Wait for Element Visibility with polling time
	public void waitForElementVisible(By locator, int timeOut, int interval) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(interval));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//wait for presence of elements
	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	//wait for element visible
	public void waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	/****************************Waits for non WebElements***************************/
	
	//wait for page title - contains
	public Boolean waitForPageTitle(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleValue));
	}
	
	//wait for page title - Is
	public boolean waitForActualPageTitle(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	//return the title
	public String doGetPageTitleContains(String titleValue, int timeOut) {
		if(waitForPageTitle(titleValue, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	
	public String doGetPageTitleIs(String title, int timeOut) {
		if(waitForActualPageTitle(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	
	//wait for url - contains
	public String waitForUrlContains(String url, int timeOut) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		try{if(wait.until(ExpectedConditions.urlContains(url))) {
			return driver.getCurrentUrl();
		}}catch(TimeoutException e) {
			return null;
		}
		return null;
	}
	
	//wait for url - Is
	public String waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.urlToBe(url))) {
				return driver.getCurrentUrl();
			}
			
		}catch(TimeoutException e) {
			return null;
		}
		return null;
	}
	
	//wait for alert and switch to it
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//Get text from Alert with waits
	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	//accept alert with wait
	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	//dismiss alert
	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
}
