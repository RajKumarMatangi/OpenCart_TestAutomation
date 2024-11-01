package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.SearchPage;

public class Tc_005_Header extends BaseClass {
    @Test
    public void test() throws Exception {
        // Navigate to HomePage and click My Account and Login
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.loginClick();
        
        // Enter login details
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(prop.getProperty("email"));
        loginPage.setPassword(prop.getProperty("password"));  // Correctly fetching password
        Thread.sleep(2000);  // It's better to replace this with an explicit wait.
        loginPage.clcikLogin();
        
        // Navigate to Desktops -> Mac
        MyAccountPage accountPage = new MyAccountPage(driver);
        accountPage.clickOnDesktopsMain();
        accountPage.clickOnMac();
        String product_text = accountPage.macTextVisible();
        if(product_text.equals("iMac")) {
        	Assert.assertTrue(true);
        }
        else {
        	Assert.assertTrue(false);
        }
        
    }
}
