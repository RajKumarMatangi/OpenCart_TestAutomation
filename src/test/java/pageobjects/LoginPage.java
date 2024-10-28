package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	//Locators
	@FindBy(xpath="//input[@placeholder='E-Mail Address']") WebElement emailaddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@type='submit']") WebElement loginbtn;
	@FindBy(xpath="//div[@class='col-sm-9']/h2[1]") WebElement myaccounttxt;
	
	//Actions
	
	public void setEmail(String email) {
		emailaddress.sendKeys(email);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clcikLogin() {
		loginbtn.click();
	}
	
   public String displayText() {
	   return myaccounttxt.getText();
   }
}
