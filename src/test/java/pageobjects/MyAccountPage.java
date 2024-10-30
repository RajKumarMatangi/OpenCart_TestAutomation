package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
   //Header Section
   @FindBy(xpath="//a[.='Desktops']") WebElement Header1_Desktops;
   @FindBy(xpath="//a[.='PC (0)']") WebElement Header_1_001_Pc;
   @FindBy(xpath="//a[.='Mac (1)']") WebElement Header_1_002_Mac;
   @FindBy(xpath="//a[.='Show AllDesktops']") WebElement Header_1_003_AllDesktops;
   @FindBy(xpath="//a[.='Laptops & Notebooks']") WebElement Header_2_Laptops_NoteBooks;
   @FindBy(xpath="//a[.='Macs (0)']") WebElement Header_2_001_Macs;
   @FindBy(xpath="//a[.='Windows (0)']") WebElement Header_2_002_Windows;
   @FindBy(xpath="//a[.='Show AllLaptops & Notebooks']") WebElement Header_2_003_All;
   @FindBy(xpath="//a[.='iMac']") WebElement macText;
   
   
   
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
   public void clickOnDesktopsMain() {
	   Actions action = new Actions(driver);
	   action.moveToElement(Header1_Desktops).click().build().perform();
   }
   public void clickOnPc() {
	   Header_1_001_Pc.click();
   }
   public void clickOnMac() {
	   Header_1_002_Mac.click();
   }
   public void clickOnAll() {
	   Header_1_003_AllDesktops.click();
   }
   public String  macTextVisible() {
	  String mac_text =  macText.getText();
	  return mac_text;
   }

}
