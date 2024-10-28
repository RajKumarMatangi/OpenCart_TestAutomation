package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;

public class Tc_001_AccountRegistration extends BaseClass{
	@Test(groups={"sanity"})
	public void test() throws Exception {
		HomePage obj = new HomePage(driver);
		Thread.sleep(1000);
		obj.clickMyAccount();
		obj.clickRegister();
		AccountRegistrationPage obj1 = new AccountRegistrationPage(driver);
		obj1.setFirstName("hello000");
		obj1.setLastName("raju00000");
		obj1.setEmail("abc1234567812345678@gmail.com");
		obj1.setTelephone("1234567890");
		obj1.setPwd("987654321");
		obj1.confirmPwd("987654321");
		obj1.clickPrivacy();
		obj1.continuebtn();
		String confirmtext = obj1.checkConfirmMsg();
		Thread.sleep(2000);
		if(confirmtext.equalsIgnoreCase("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		}
	
	
	}


