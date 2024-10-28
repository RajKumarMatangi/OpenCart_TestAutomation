package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
   	 
    	super(driver);
    }
    
    //Locators
   @FindBy(xpath="//span[.='My Account']") WebElement Myaccountclick;
   @FindBy(xpath="//a[text()='Register']") WebElement Registerclick;
   @FindBy(xpath="//a[.='Login']") WebElement loginclick;
    //Actions
     public void clickMyAccount() {
    	 Myaccountclick.click();
     }
     
     public void clickRegister() {
    	 Registerclick.click();
     }
     
     public void loginClick() {
    	 loginclick.click();
     }


}
