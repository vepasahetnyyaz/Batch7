package pages.storeapppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppSignInPage {

    WebDriver driver;

    public StoreAppSignInPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "pass")
    public WebElement passwordInput;

    @FindBy(id = "send2")
    public WebElement signInBtn;
}
