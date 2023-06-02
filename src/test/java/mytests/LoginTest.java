
package mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	
	@DataProvider
	public Object[][] loginTestData() {
		return new Object[][] {
							{"admin@gmail.com", "admin@123"},
							{"cust@gmail.com", "cust@123"},
							{"vendor@gmail.com", "vendor@123"},
							{"@#4","vendor@123"},
							{"vendor@gmail.com","@#$"},
							{" ", " "},
							{null, null}
		};
	}
	
	@Test(dataProvider="loginTestData")
	public void loginTest(String userName, String password) {
		Assert.assertTrue(doLogin(userName, password));
	}
	
	public boolean doLogin(String userName, String password) {
		System.out.println("UserName : "+userName);
		System.out.println("Password : "+password);
		System.out.println("Login succesful");
		return true;
	}

}
