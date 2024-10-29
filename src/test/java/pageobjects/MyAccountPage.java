package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
   public MyAccountPage(WebDriver driver) {
	   super(driver);
   }
   
   //Locators
   @FindBy(xpath="//h2[.='My Account']") WebElement myaccounttxt;
   @FindBy(xpath="//a[@class='list-group-item' and text()='Logout']") WebElement logoutbtn;
   
   //Actions
   public String getText() {
	   
	   return myaccounttxt.getText();
   }
   
   public void clickLogout() {
	   logoutbtn.click();
   }

}
