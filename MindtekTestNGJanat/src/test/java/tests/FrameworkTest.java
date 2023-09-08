package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameworkTest {

    WebDriver driver;

    @BeforeMethod(groups = {"regression"})
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = {"regression"})
    public void verifyGoogle(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
    }



    @AfterMethod(groups = {"regression"})
    public void teardown(){
        driver.quit();
    }

}
