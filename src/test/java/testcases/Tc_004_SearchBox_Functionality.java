package testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.SearchPage;

public class Tc_004_SearchBox_Functionality extends BaseClass{
	@Test()
	public void test() {
		
		HomePage obj1 = new HomePage(driver);
		obj1.clickMyAccount();
		obj1.loginClick();
		LoginPage obj2 = new LoginPage(driver);
		obj2.setEmail(prop.getProperty("email"));
		obj2.setPassword(prop.getProperty("password"));
		obj2.clcikLogin();
		MyAccountPage obj3 = new MyAccountPage(driver);
		obj3.sendTextOnSearch();
		obj3.clickOnSearch();
		SearchPage obj4 = new SearchPage(driver);
		String actual_text = obj4.confirmProduct();
		if(actual_text.equals("MacBook")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		
	
	}
	

}
