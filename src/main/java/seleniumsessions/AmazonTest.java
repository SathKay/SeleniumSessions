package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String browser = "chrome";
		BrowserUtil br = new BrowserUtil();
		
		br.launchBrowser(browser);
		
		br.enterUrl("https:www.amazon.com");
		
		String title = br.getPageTitle();
		if(title.contains("amazon")) {
			System.out.println("The Page title is correct");
		}
		
		if(br.getUrl().contains("amazon")) {
			System.out.println("The given Url is correct");
		}
		
		br.quitBrowser();

	}

}
