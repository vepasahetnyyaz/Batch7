package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.blazedemopages.BlazeDemoConfirmationPage;
import pages.blazedemopages.BlazeDemoFlightsPage;
import pages.blazedemopages.BlazeDemoHomePage;
import pages.blazedemopages.BlazeDemoPurchaseInfoPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class BlazeDemoZhanatFeb18Tests extends TestBase {

    @Test(groups = {"regression"})
    public void verifyPurchase(){

        String cardName = "American Express";
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));

        BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage();
        blazeDemoHomePage.chooseDestination("San Diego", "New York");

        BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();
        blazeDemoFlightsPage.chooseThisFlightBtn.click();

        BlazeDemoPurchaseInfoPage blazeDemoPurchaseInfoPage = new BlazeDemoPurchaseInfoPage();
        blazeDemoPurchaseInfoPage.firstLastName.sendKeys("David Clark");
        blazeDemoPurchaseInfoPage.address.sendKeys("123 Washington ave.");
        blazeDemoPurchaseInfoPage.city.sendKeys("Austin");
        blazeDemoPurchaseInfoPage.state.sendKeys("TX");
        blazeDemoPurchaseInfoPage.zipCode.sendKeys("12345");
        Select cardTypeDropdown = new Select(blazeDemoPurchaseInfoPage.cardType);
        cardTypeDropdown.selectByVisibleText(cardName);
        blazeDemoPurchaseInfoPage.cardNumber.sendKeys("mycreditcardnumber");
        blazeDemoPurchaseInfoPage.creditCardMonth.sendKeys("11");
        blazeDemoPurchaseInfoPage.creditCardYear.sendKeys("2025");
        blazeDemoPurchaseInfoPage.nameOnCard.sendKeys("David Clark");
        blazeDemoPurchaseInfoPage.purchaseBtn.click();



        BlazeDemoConfirmationPage blazeDemoConfirmationPage = new BlazeDemoConfirmationPage();
        String actualValue = driver.getTitle();
        Assert.assertEquals(actualValue,"BlazeDemo Confirmation");



    }

}
