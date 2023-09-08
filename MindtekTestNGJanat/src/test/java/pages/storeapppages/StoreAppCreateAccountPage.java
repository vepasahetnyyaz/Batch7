package pages.storeapppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppCreateAccountPage {

    WebDriver driver;

    public StoreAppCreateAccountPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(id = "lastname")
    public  WebElement lastname;

    @FindBy(id = "email_address")
    public WebElement emailaddress;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "password-confirmation")
    public WebElement passwordConfirm;

    @FindBy(xpath = "//button[@class='action submit primary']")
    public WebElement createAccountBtn;

}
