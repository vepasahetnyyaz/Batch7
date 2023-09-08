package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.blazedemopages.BlazeDemoDestWeekPage;
import pages.blazedemopages.BlazeDemoFlightInfoPage;
import pages.blazedemopages.BlazeDemoFlightsPage;
import pages.blazedemopages.BlazeDemoHomePage;
import utilities.ConfigReader;
import utilities.TestBase;



public class BlazeDemoTests extends TestBase {

    @Test(groups = {"regression","smoke", "blazedemotest"})
    public void verifyFindFlights(){
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));

        String fromCity = "San Diego";
        String toCity = "Rome";

        BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage();
        BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();

        blazeDemoHomePage.chooseDestination("San Diego", "Rome");

        String expectedFlightText = "Flights from "+fromCity+" to "+toCity+":";

        Assert.assertEquals(blazeDemoFlightsPage.flightsText.getText(),expectedFlightText);

    }

    @Test(groups = {"regression", "blazedemotest"})
    public void verifyDestinationOfTheWeek(){
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage();
        blazeDemoHomePage.destinationOfWeekLink.click();

        BlazeDemoDestWeekPage blazeDemoDestWeekPage = new BlazeDemoDestWeekPage();
        blazeDemoDestWeekPage.destinationText.click();
        String expectedDestinationText = "Destination of the week: Hawaii !";

        Assert.assertEquals(blazeDemoDestWeekPage.destinationText.getText(),expectedDestinationText);
    }

    @Ignore  // --> ignores this test case
    @Test(groups = {"regression", "blazedemotest"})
    public void verifyFlightInfo(){
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage();
        blazeDemoHomePage.chooseDestination("San Diego", "Rome");

        BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();
        String expectedAirlineName = blazeDemoFlightsPage.airlineName.getText();
        String expectedFlightNumber = blazeDemoFlightsPage.flightNumber.getText();
        String expectedPrice = blazeDemoFlightsPage.price.getText();
        blazeDemoFlightsPage.chooseThisFlightBtn.click();

        BlazeDemoFlightInfoPage blazeDemoFlightInfoPage = new BlazeDemoFlightInfoPage();
        String actualAirline = blazeDemoFlightInfoPage.airlineName.getText();
        String actualFlightNumber = blazeDemoFlightInfoPage.flightNumber.getText();
        String actualPrice = blazeDemoFlightInfoPage.price.getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualAirline.substring(actualAirline.indexOf(" ")+1), expectedAirlineName);
        softAssert.assertEquals(actualFlightNumber,expectedFlightNumber);
        softAssert.assertEquals(actualPrice,expectedPrice);

        softAssert.assertAll();


    }

}
