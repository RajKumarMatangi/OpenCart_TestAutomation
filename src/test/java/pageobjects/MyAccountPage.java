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
   @FindBy(xpath="//input[@name='search']") WebElement search;
   @FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement btnsearch;
   
   
   
   //Actions
   public String getText() {
	   
	   return myaccounttxt.getText();
   }
   
   public void clickLogout() {
	   logoutbtn.click();
   }
   
   public void sendTextOnSearch() {
	   search.sendKeys("Mac");
   }
   public void clickOnSearch() {
	   btnsearch.click();
   }

}
