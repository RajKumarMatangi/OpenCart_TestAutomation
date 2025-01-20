package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;

public class Tc_006_AddToCart extends BaseClass {
    @Test(groups = {"AddTocart"})
    public void testAddtoCartFunctionalitywithoutLogin() throws Exception {
        HomePage obj = new HomePage(driver);
        
        // Navigate to iPhone
        obj.iphnClick();
       
        //Adding iphone to the cart
        obj.iphcartClick();
        
        if(obj.isSuccessAlertDisplayed()==true) {
        	Assert.assertTrue(true);
        }
        else {
        	Assert.assertTrue(false);
        }
        
        
 
   
    }
}
