package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	public SearchPage(WebDriver driver) {
		super(driver);
	}
   
	@FindBy(xpath="//a[.='MacBook']") WebElement macbook;
	@FindBy(xpath="//img[@src='https://tutorialsninja.com/demo/image/cache/catalog/demo/imac_3-74x74.jpg']") WebElement macImage;
	   
	
	public  String confirmProduct() {
		
		String textcnfrm = macbook.getText();
		return textcnfrm;
		
	}
	 public boolean macImageVisible() {
		   boolean img_status = macImage.isDisplayed();
		   return img_status;
	   }

	
}
