package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchPage {

    public EtsyAppSearchPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div/ol/li/div/div/a/div[2]/h3")
    public List<WebElement> itemsNameList;

    @FindBy(xpath = "//span[@class='wt-hide-xs wt-show-md filter-expander']")
    public WebElement allFiltersBtn;


    @FindBy(xpath = "//label[@for='price-input-4']")
    public WebElement over1500Btn;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']")
    public WebElement applyFilterBtn;

    @FindBy(xpath = "//div[@class='wt-grid wt-pl-xs-0 wt-pr-xs-0 search-listings-group']//span[@class='currency-value']")
    public List<WebElement> listOfPrices;

    @FindBy(xpath = "//label[@for='price-input-2']")
    public WebElement price50To500Btn;

    @FindBy(xpath = "//label[@for='price-input-custom']")
    public WebElement customBtn;

    @FindBy(id = "search-filter-min-price-input")
    public WebElement customMinPrice;

    @FindBy(id = "search-filter-max-price-input")
    public WebElement customMaxPrice;

    @FindBy(xpath = "//label[@for='special-offers-free-shipping']")
    public WebElement specialOfferFree;

    @FindBy(xpath = "//label[@for='special-offers-on-sale']")
    public WebElement specialOfferOnSale;





}
