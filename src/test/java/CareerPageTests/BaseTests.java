package CareerPageTests;

import Pages.CareersPage;
import Pages.HomePage;
import Pages.JobsPage;
import Pages.South_AfricaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected CareersPage cereerPage;
    protected JobsPage jobPage;
    protected South_AfricaPage saPage;



    @BeforeClass
    @Parameters({"browser","url"})
    public void setUp(String browser,String app) {

        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
           // driver.get("https://www.ilabquality.com/");
            driver.manage().window().maximize();
            homePage = new HomePage(driver);
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new FirefoxDriver();
           // driver.get("https://www.ilabquality.com/");
            driver.manage().window().maximize();
            homePage = new HomePage(driver);
        }
        driver.get(app); //driver.get("https://www.ilabquality.com/");
    }


    @AfterClass
    public void tearDown() {

        //driver.quit();
    }
}
