package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.saucedemopages.SauceDemoHomePage;
import pages.saucedemopages.SauceDemoLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class SauceDemoTests extends TestBase {

    @Test(priority = 0, groups = {"regression","smoke","saucedemo", "login"})
    public void verifySauceLoginPositive(){

        driver.get(ConfigReader.getProperty("SauceDemoURL"));

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        username.sendKeys(ConfigReader.getProperty("standartUser"));
        password.sendKeys(ConfigReader.getProperty("saucePassword"));
        loginBtn.click();

        String actualText = driver.findElement(By.xpath("//span[contains(text(),\"Products\")]")).getText();
        String expectedText = "Products";


        Assert.assertEquals(actualText,expectedText);
    }

    @Test(priority = 1, groups = {"regression","smoke","saucedemo", "login"})
    public void verifySauceLoginNegative(){

        driver.get(ConfigReader.getProperty("SauceDemoURL"));

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        username.sendKeys(ConfigReader.getProperty("lockedOutUser"));
        password.sendKeys(ConfigReader.getProperty("saucePassword"));
        loginBtn.click();

        String actual = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]")).getText();
        String expected = "Epic sadface: Sorry, this user has been locked out.";

        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 2, groups = {"regression","smoke","saucedemo"})
    public void verifyPriceHighToLow(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));

        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();

        sauceDemoLoginPage.username.sendKeys(ConfigReader.getProperty("standartUser"));
        sauceDemoLoginPage.password.sendKeys(ConfigReader.getProperty("saucePassword"));
        sauceDemoLoginPage.loginBtn.click();

        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();

        Select sortingDropdown = new Select(sauceDemoHomePage.sortDropdown);
        sortingDropdown.selectByValue("hilo");

        for (int i = 0; i<sauceDemoHomePage.itemPrices.size()-1; i++){
            double item1 = Double.parseDouble(sauceDemoHomePage.itemPrices.get(i).getText().substring(1));
            double item2 = Double.parseDouble(sauceDemoHomePage.itemPrices.get(i+1).getText().substring(1));

            System.out.println(item1+" is greater than "+item2);
            Assert.assertTrue(item1>=item2);
        }




    }

}
