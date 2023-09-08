package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MindtekPizzaAppPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Map;
import java.util.Objects;

public class MindtekPizzaAppSteps {

    String costValue = "";

    WebDriver driver = Driver.getDriver();
    MindtekPizzaAppPage mindtekPizzaAppPage = new MindtekPizzaAppPage();

    @When("user creates pizza order")
    public void user_creates_pizza_order(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        Map<String, Object> data = dataTable.asMap(String.class, Object.class);
        System.out.println(data.toString());
        BrowserUtils.selectDropdownByValue(mindtekPizzaAppPage.pizzaDropdown,data.get("Pizza"));
        BrowserUtils.selectDropdownByValue(mindtekPizzaAppPage.toppings1,data.get("Topping1"));
        BrowserUtils.selectDropdownByValue(mindtekPizzaAppPage.toppings2,data.get("Topping2"));
        mindtekPizzaAppPage.quantity.clear();
        mindtekPizzaAppPage.quantity.sendKeys(data.get("Quantity").toString());
        mindtekPizzaAppPage.name.sendKeys(data.get("Name").toString());
        mindtekPizzaAppPage.email.sendKeys(data.get("Email").toString());
        mindtekPizzaAppPage.phone.sendKeys(data.get("Phone").toString());

        costValue = mindtekPizzaAppPage.cost.getAttribute("value");

        if (data.get("Payment").equals("Cash on Pickup")){
            mindtekPizzaAppPage.cashPayment.click();
        }else{
            mindtekPizzaAppPage.creditPayment.click();
        }
        mindtekPizzaAppPage.placeOrderBtn.click();
    }

    @Then("user validates that order is creates with message {string} {string} {string}")
    public void user_validates_that_order_is_creates_with_message(String success, String quantity, String pizza) {

        String expectedMessage = success+costValue+" "+pizza;
        String actualMessage = mindtekPizzaAppPage.successMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);


    }

}
