package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	public SearchPage(WebDriver driver) {
		super(driver);
	}
   
	@FindBy(xpath="//a[.='MacBook']") WebElement macbook;
	
	public  String confirmProduct() {
		
		String textcnfrm = macbook.getText();
		return textcnfrm;
		
	}
}
