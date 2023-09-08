package pages.blazedemopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazeDemoPurchaseInfoPage {

    WebDriver driver;

    public BlazeDemoPurchaseInfoPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputName")
    public WebElement firstLastName;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "zipCode")
    public WebElement zipCode;

    @FindBy(id = "cardType")
    public WebElement cardType;

    @FindBy(id = "creditCardNumber")
    public WebElement cardNumber;

    @FindBy(id = "creditCardMonth")
    public WebElement creditCardMonth;

    @FindBy(id ="creditCardYear")
    public WebElement creditCardYear;

    @FindBy(id = "nameOnCard")
    public WebElement nameOnCard;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    public WebElement purchaseBtn;


}
