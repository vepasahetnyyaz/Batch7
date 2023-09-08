package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class BrowserUtils {

    /**
     * This method generates emails with random usernames.
     * Ex:
     *      .getRandomEmail() -> returns: user1234sdfbscinadkjn@gmail.com
     */

    public static String getRandomEmail(){
        UUID uuid = UUID.randomUUID();
        return "username"+uuid+"@gmail.com";
    }

    /**
     * This method accepts WebElement of dropdown and String value of dropdown,
     * and will select provided value in dropdown.
     * Ex:
     *      .selectDropdownByValue() -> it will select an option by value.
     */

    public static void selectDropdownByValue(WebElement dropdown, Object value){
        Select select = new Select(dropdown);
        select.selectByValue(value.toString());
    }


    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForTextToBePresentInElement(WebDriver driver, By locator, String text, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static boolean waitForTitleToContain(WebDriver driver, String title, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.titleContains(title));
    }
}
