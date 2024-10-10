package testSuite;

import org.testng.annotations.Test;

import pageObjects.DemoQABookStoreLogin;
import utilities.DataProviders;

public class TestAction03Login extends BaseClass{
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups={"DataDriven"}) // getting Data providers from different class
	public void tc_03_BookStoreLogin(String username,String password) throws Exception {
		logger.info("******tc_03_BookStoreLogin**********");
//		new DemoQABookStoreLogin(driver).clickBookStoreApplication();
//		new DemoQABookStoreLogin(driver).clickBookStoreLoginBtn();
		new DemoQABookStoreLogin(driver).enterUserName(username);
		new DemoQABookStoreLogin(driver).enterPassword(password);
		new DemoQABookStoreLogin(driver).clickLoginbtn();
		new DemoQABookStoreLogin(driver).clickLogoutBtn();
		
		/** Data is valid -login success -test pass - logout
		 *                  login failed - test fail
		 *                 
		 *  Data is invalid - login success - test fail - logout
		 *                    login failed - test pass 
		 */
	}
}
