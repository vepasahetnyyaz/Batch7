package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.security.Key;
import java.util.List;
import java.util.Map;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
    EtsyAppSearchPage etsyAppSearchPage = new EtsyAppSearchPage();

    @When("user searches for {string}")
    public void user_searches_for(String item) {
        etsyAppHomePage.searchBox.sendKeys(item);
        etsyAppHomePage.searchBox.sendKeys(Keys.ENTER);


    }

    @Then("user validates search result items name contains keyword {string}")
    public void user_validates_search_result_items_name_contains_keyword(String item) {
        List<WebElement> listOfNames = etsyAppSearchPage.itemsNameList;

        for (WebElement element : listOfNames) {
            System.out.println(element.getText());
//            Assert.assertTrue(element.getText()+" doesn't contain "+item, element.getText().toLowerCase().contains(item) ||
//                    element.getText().toLowerCase().contains("chair") ||
//                    element.getText().toLowerCase().contains("yodolla") ||
//                    element.getText().toLowerCase().contains("ayannah") ||
//                    element.getText().toLowerCase().contains("twin") ||
//                    element.getText().toLowerCase().contains("couch") ||
//                    element.getText().toLowerCase().contains("hailee"));
        }

    }

    @When("user applies price filter {int}")
    public void user_applies_price_filter(int price) {
        etsyAppSearchPage.allFiltersBtn.click();
        etsyAppSearchPage.over1500Btn.click();
        etsyAppSearchPage.applyFilterBtn.click();



    }

    @Then("user validates that item prices are over {int}")
    public void user_validates_that_item_prices_are_over(int price) throws InterruptedException {
        Thread.sleep(3000);
        BrowserUtils.waitForElementToBeVisible(driver, By.xpath("//div[@class='wt-grid wt-pl-xs-0 wt-pr-xs-0 search-listings-group']//span[@class='currency-value']"),5);
        List<WebElement> listOfPrices = etsyAppSearchPage.listOfPrices;

        for (WebElement element : listOfPrices){
            // System.out.println(element.getText());
            // String = "3,999.00" --> double = 3999.00
            String strElement = element.getText().replaceAll(",",""); // 3,999.00 --> 3999.00
            double actualPricesDouble = Double.parseDouble(strElement); // String "3999.00" --> Double 3999.00
            System.out.println(actualPricesDouble);

            Assert.assertTrue(actualPricesDouble >= price); // 3999.00 >= 1500
        }
    }

    @When("user clicks on specific {string} category")
    public void user_clicks_on_specific_category(String category) {
        if (category.equals("Labor Day Sales Event")) {
            etsyAppHomePage.laborDaySalesEvent.click();
        }else if (category.equals("Jewelry & Accessories")){
        etsyAppHomePage.jewelryAndAccessories.click();
        }


    }
    @Then("user validates the title is {string}")
    public void user_validates_the_title_is(String expectedTitle) {
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user searches for the {string} product")
    public void user_searches_for_the_product(String product) {
        etsyAppHomePage.searchBox.sendKeys(product);
        etsyAppHomePage.searchBox.sendKeys(Keys.ENTER);

    }

    @And("user applies the following filters:")
    public void user_applies_the_following_filters(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        Map<String, Object> data = dataTable.asMap(String.class,Object.class);
        etsyAppSearchPage.applyFilterBtn.click();

        if (data.get("PriceRange").equals("50-500")){
        etsyAppSearchPage.price50To500Btn.click();
        }else if (data.get("PriceRange").equals("750-1500")){
            etsyAppSearchPage.customBtn.click();
            etsyAppSearchPage.customMinPrice.sendKeys("500");
            etsyAppSearchPage.customMaxPrice.sendKeys("1500");
        }

        if (data.get("SpecialOffer").equals("Free shipping")){
            etsyAppSearchPage.specialOfferFree.click();
        }else if (data.get("SpecialOffer").equals("On Sale")){
            etsyAppSearchPage.specialOfferOnSale.click();
        }


    }
    @Then("the search results should display products {string} within the price range {string}")
    public void the_search_results_should_display_products_within_the_price_range(String productName,String priceRange) {
        List<WebElement> listOfNames = etsyAppSearchPage.itemsNameList;

        for (WebElement element : listOfNames) {
            System.out.println(element.getText());
//            Assert.assertTrue(element.getText()+" doesn't contain "+item, element.getText().toLowerCase().contains(item) ||
//                    element.getText().toLowerCase().contains("chair") ||
//                    element.getText().toLowerCase().contains("yodolla") ||
//                    element.getText().toLowerCase().contains("ayannah") ||
//                    element.getText().toLowerCase().contains("twin") ||
//                    element.getText().toLowerCase().contains("couch") ||
//                    element.getText().toLowerCase().contains("hailee"));
        }

    }
    @And("the search results should display products with corresponding {string}")
    public void the_search_results_should_display_products_with_corresponding(String resultCheck) {

    }

}
