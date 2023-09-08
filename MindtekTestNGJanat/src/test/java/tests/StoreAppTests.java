package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.storeapppages.StoreAppCreateAccountPage;
import pages.storeapppages.StoreAppHomePage;
import pages.storeapppages.StoreAppSignInPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;


public class StoreAppTests extends TestBase {

    String email;
    String password;

    @DataProvider(name = "createAccountData")
    public static Object[][] testData() {
        return new Object[][]{
                {"Harsh", "Patel", BrowserUtils.getRandomEmail() ,"QWerty123$"},
                {"Jane", "Doe", BrowserUtils.getRandomEmail(), "MyPassword1#"},
                {"Zarif", "Orunov", BrowserUtils.getRandomEmail(), "TestPwd123!"}

        };
    }

    @Test(groups = {"regression", "storeapp", "createaccount"}, dataProvider = "createAccountData")
    public void verifyCreateAccount(String firstname, String lastName,String email, String password) {

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        storeAppHomePage.createAccountLink.click();

        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();
        storeAppCreateAccountPage.firstname.sendKeys(firstname);
        storeAppCreateAccountPage.lastname.sendKeys(lastName);

//        String user = "user";
//        UUID uuid = UUID.randomUUID();
//        email = user + uuid + "@gmail.com";

// global variable = dataProvider
        this.email = email;
        this.password=password;
        storeAppCreateAccountPage.emailaddress.sendKeys(email);
        storeAppCreateAccountPage.password.sendKeys(password);
        storeAppCreateAccountPage.passwordConfirm.sendKeys(password);

        System.out.println("User Email: "+email);
        System.out.println("User Password: "+password);

        storeAppCreateAccountPage.createAccountBtn.click();
        Assert.assertTrue(driver.getTitle().contains("My Account"));

    }

    @Test(groups = {"regression", "storeapp", "signIn"}, dependsOnMethods = {"verifyCreateAccount"})
    public void verifySignIn(){

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        storeAppHomePage.signIn.click();

        StoreAppSignInPage storeAppSignInPage = new StoreAppSignInPage();
        storeAppSignInPage.emailInput.sendKeys(email);
        storeAppSignInPage.passwordInput.sendKeys(password);
        storeAppSignInPage.signInBtn.click();
        Assert.assertTrue(driver.getTitle().contains("Home Page"));


    }
}
