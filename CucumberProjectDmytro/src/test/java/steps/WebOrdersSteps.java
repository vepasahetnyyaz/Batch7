package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class WebOrdersSteps {

    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    String username;


    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        System.out.println(password);
        System.out.println(username);
        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);

        this.username = username;
    }

    @And("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        webOrdersLoginPage.loginBtn.click();

    }

    @Then("user validates application is logged in")
    public void user_validates_application_is_logged_in() {
        String expected = "Welcome, " + username + "! | Logout";
        String actual = driver.findElement(By.xpath("//div[@class='login_info']")).getText();

        Assert.assertEquals(expected, actual);

    }

    @Then("user validates an error message {string}")
    public void user_validates_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = webOrdersLoginPage.errorMessage.getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);


    }

}
