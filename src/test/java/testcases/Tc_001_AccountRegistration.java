package testcases;

import org.apache.commons.lang3.RandomStringUtils;
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
		obj1.setFirstName(randomString().toLowerCase());
		obj1.setLastName(randomString().toUpperCase());
		obj1.setEmail(randomString()+"@gmail.com");
		obj1.setTelephone(randomPhoneno());
		String pwd = randomPassword();
		obj1.setPwd(pwd);
		obj1.confirmPwd(pwd);
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
	public String  randomString() {
		String name = RandomStringUtils.randomAlphabetic(5);
		return name;
	}
	public String randomPhoneno() {
		String phone = RandomStringUtils.randomNumeric(10);
		return phone;
	}
	
	public String randomPassword() {
		String password = RandomStringUtils.randomAlphanumeric(8);
		return password;
	}
		}
	


