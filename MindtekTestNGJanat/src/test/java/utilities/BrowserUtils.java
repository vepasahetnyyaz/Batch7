package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public static void selectDropdownByValue(WebElement dropdown, String value){
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
}
