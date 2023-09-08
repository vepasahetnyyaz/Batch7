package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    static WebDriver driver;

    /**
     * This method sets up Webdriver type based on provided browser type
     * in Configuration.properties file.
     * @return Webdriver
     */

    public static WebDriver getDriver(){
        String browser=ConfigReader.getProperty("browser");
        if(driver==null || ((RemoteWebDriver)driver).getSessionId()==null){
            if (browser.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(false);
                options.addArguments("--incognito");
                driver=new ChromeDriver(options);
            }else if (browser.equals("edge")){
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            }else if(browser.equals("ie")){
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
            }else if (browser.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
            }else if (browser.equals("safari")){
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            } else {
                throw new RuntimeException("Invalid browser.");
            }
        }else {
            return driver;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
