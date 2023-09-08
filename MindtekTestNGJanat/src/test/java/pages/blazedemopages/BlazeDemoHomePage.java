package pages.blazedemopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class BlazeDemoHomePage {

    WebDriver driver;

    public BlazeDemoHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "fromPort")
    public WebElement fromCity;

    @FindBy(name = "toPort")
    public WebElement toCity;

    @FindBy(xpath = "//input[@value='Find Flights']")
    public WebElement findFlighthsBtn;

    @FindBy(partialLinkText = "destination of the week!")
    public WebElement destinationOfWeekLink;

    public void chooseDestination(String fromCity, String toCity){
        Select fromCityDropdown = new Select(this.fromCity);
        Select toCityDropdown = new Select(this.toCity);
        fromCityDropdown.selectByValue(fromCity);
        toCityDropdown.selectByValue(toCity);
        findFlighthsBtn.click();

    }

}
