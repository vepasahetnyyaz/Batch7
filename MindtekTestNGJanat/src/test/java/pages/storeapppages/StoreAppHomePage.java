package pages.storeapppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppHomePage {
    WebDriver driver;

    public StoreAppHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Create an Account")
    public WebElement createAccountLink;

    @FindBy(linkText = "Sign In")
    public WebElement signIn;

}
