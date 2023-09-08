package pages.blazedemopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazeDemoDestWeekPage {

    WebDriver driver;

    public BlazeDemoDestWeekPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Destination')]")
    public WebElement destinationText;
}
