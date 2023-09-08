package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyAppHomePage {

    public EtsyAppHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@class='wt-display-table-cell wt-text-left-xs']")
    public WebElement laborDaySalesEvent;

    @FindBy(id = "catnav-primary-link-10855")
    public WebElement jewelryAndAccessories;

}
