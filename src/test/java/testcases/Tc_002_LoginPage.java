package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

public class Tc_002_LoginPage extends BaseClass {

    @Test(dataProvider ="LoginData", dataProviderClass = DataProviders.class, groups = {"Regression" ,"WithDataProvider"})
    public void testLoginFunctionality(String mailId, String password, String expectedOutcome) throws Exception {
        logger.info("Starting Login Test");

        // Page object instances
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage accountPage = new MyAccountPage(driver);
        // Navigate and perform login
        homePage.clickMyAccount();
        Thread.sleep(2000);
        homePage.loginClick();
        
        loginPage.setEmail(mailId);
        loginPage.setPassword(password);
        loginPage.clcikLogin();
        Thread.sleep(2000);
        
        // Validating login outcome
        String actualText = accountPage.getText();
        boolean isLoginSuccessful = "My Account".equals(actualText);
        
        if ("valid".equalsIgnoreCase(expectedOutcome)) {
            Assert.assertTrue(isLoginSuccessful, "Login failed with valid credentials.");
        } else {
            Assert.assertFalse(isLoginSuccessful, "Login succeeded with invalid credentials.");
        }
    }
}
