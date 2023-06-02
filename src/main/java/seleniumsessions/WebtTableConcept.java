package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtTableConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(option);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		System.out.println(getCompanyName("Helen Bennett"));
		System.out.println(getCountryName("Helen Bennett"));
		
		System.out.println("rows:"+getRowCount());
		System.out.println("columns:"+getColumnCount());
		System.out.println("Headers:"+getHeaderList());
		
		
		//Logic to print a particular column of the table
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
//		String before_xpath = "//table[@id=\"customers\"]/tbody/tr[";
//		String after_xpath = "]/td[1]";
		
//		for(int i=2;i<=getRowCount()+1;i++) {
//			String xpath = before_xpath+i+after_xpath;
//			//System.out.println(xpath);
//			System.out.println(driver.findElement(By.xpath(xpath)).getText());
//		}
		
		//logic to print the entire web table(row wise)
		
		String before_xpath = "//table[@id=\"customers\"]/tbody/tr[";
		String after_xpath = "]/td[";
		
//		for(int row=2;row<=getRowCount()+1;row++) {
//			for(int col=1;col<=getColumnCount();col++) {
//				String xpath = before_xpath+row+after_xpath+col+"]";
//				String text = driver.findElement(By.xpath(xpath)).getText();
//				System.out.print(text +"   ");
//			}
//			System.out.println();
//		}
		
		//logic to print the table (column wise)
		
//		for(int col=1;col<=getColumnCount();col++) {
//			for(int row=2;row<=getRowCount()+1;row++) {
//				String xpath = before_xpath+row+after_xpath+col+"]";
//				String text = driver.findElement(By.xpath(xpath)).getText();
//				System.out.print(text+"  ");
//			}
//			System.out.println();
//		}
		
		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		
		//*[@id="customers"]/tbody/tr[1]/th[3]
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//*[@id="customers"]/tbody/tr[3]/td[3]
		
		List<String> list = getColumnValue("company");
		System.out.println(list);
		String value = "Roland Mendel";
		for(String e:list) {
			if(e.equals(value)) {
				System.out.println("The given value is present in the table");
				break;
			}
		}

	}
	
	public static List<String> getColumnValue(String headerName) {
		int col=0;
		if(headerName.equalsIgnoreCase("Company")) {
			col=1;
		}
		else if(headerName.equalsIgnoreCase("Contact")) {
			col=2;
		}
		else if(headerName.equalsIgnoreCase("Country")) {
			col=3;
		}
		else {
			System.out.println("Given header is not available in the table");
		}
		
		
		List<String> columnList = new ArrayList<String>();
		
		for(int row=2;row<=getRowCount()+1;row++) {
			String xpath = "//table[@id=\"customers\"]/tbody/tr["+row+"]/td["+col+"]";
			String text = driver.findElement(By.xpath(xpath)).getText();
			columnList.add(text);
		}
		return columnList;
	}
	
	public static int getRowCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//tr")).size()-1;
	}
	
	public static int getColumnCount() {
		return driver.findElements(By.xpath("(//table[@id='customers']/tbody/tr)[1]/th")).size();
	}
	
	public static List<String> getHeaderList() {
		List<WebElement> columnList = driver.findElements(By.xpath("(//table[@id='customers']/tbody/tr)[1]/th"));
		List<String> header = new ArrayList<String>();
		for(WebElement e:columnList) {
			String text = e.getText();
			header.add(text);
		}
		return header;
	}
	
	public static String getCompanyName(String name) {
		WebElement companyName = driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td"));
		return companyName.getText();
	}
	
	public static String getCountryName(String name) {
		WebElement countryName = driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td"));
		return countryName.getText();
	}

}
