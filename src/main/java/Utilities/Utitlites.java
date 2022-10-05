package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Utitlites {

    protected static WebDriver driver;

    public static WebDriver getWebDriver() {
        return driver;
    }

    public void WebDriverSetup(WebDriver DriverTest) {
        this.driver = DriverTest;
    }

    public WebDriver initializeWeDriver(String sdriverName, String strURL) {

        try {
            String operatingSystem = System.getProperty("os.name");
            switch (sdriverName.toUpperCase()) {

                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    System.setProperty("webdriver.chrome.silentOutput", "true");
                    ChromeOptions ChromeOption = new ChromeOptions();
                    driver = new ChromeDriver(ChromeOption);
                    break;

                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions FireFoxOption = new FirefoxOptions();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        driver.manage().window().maximize();
        driver.get(strURL);
        return driver;
    }


}
