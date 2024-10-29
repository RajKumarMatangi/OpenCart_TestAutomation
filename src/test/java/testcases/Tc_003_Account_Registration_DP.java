package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

public class Tc_003_Account_Registration_DP extends BaseClass{
	@Test(dataProvider="Registration_Data" , dataProviderClass = DataProviders.class)
	public void test(String fname , String lname , String email , String telephone , String pwd , String cpwd ) throws Exception {
		HomePage obj = new HomePage(driver);
		Thread.sleep(1000);
		obj.clickMyAccount();
		Thread.sleep(1000);
		obj.clickRegister();
		AccountRegistrationPage obj1 = new AccountRegistrationPage(driver);
		obj1.setFirstName(fname);
		obj1.setLastName(lname);
		obj1.setEmail(email);
		obj1.setTelephone(telephone);
		obj1.setPwd(pwd);
		obj1.confirmPwd(cpwd);
		obj1.clickPrivacy();
		obj1.continuebtn();
		String confirmtext = obj1.checkConfirmMsg();
		Thread.sleep(2000);
		if(confirmtext.equalsIgnoreCase("Your Account Has Been Created!")) {
			MyAccountPage obj2 = new MyAccountPage(driver);
			obj2.clickLogout();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}	  
		}
		}
	


