package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }
    
    //Locators
    @FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
    @FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
    @FindBy(xpath="//input[@id='input-email']") WebElement email;
    @FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
    @FindBy(xpath="//input[@id='input-password']") WebElement pwd;
    @FindBy(xpath="//input[@id='input-confirm']") WebElement cnfrmpwd;
    @FindBy(xpath="//input[@type='checkbox' and @name='agree']") WebElement privacy;
    @FindBy(xpath="//input[@class='btn btn-primary']") WebElement Continue;
    @FindBy(xpath="//div[@id='content']//h1") WebElement confirmmsg;
    
    //Actions
    
    public void setFirstName(String fname) {
    	firstname.sendKeys(fname);    	
    }
    public void setLastName(String lname) {
    	lastname.sendKeys(lname);
    }
    public void setEmail(String mail) {
    	email.sendKeys(mail);
    	
    }
    public void setTelephone(String phone) {
    	telephone.sendKeys(phone);
    }
    public void setPwd(String Pwd) {
    	pwd.sendKeys(Pwd);
    }
    public void confirmPwd(String CPwd) {
    	cnfrmpwd.sendKeys(CPwd);
    }
    public void clickPrivacy() {
    	privacy.click();
    }
    public void continuebtn() {
    	Continue.click();
    }
    public String checkConfirmMsg() {
    	return confirmmsg.getText();
    }

   
}
