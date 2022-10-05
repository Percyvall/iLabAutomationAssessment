package CareerPageTests;

import Pages.CareersPage;
import Pages.HomePage;
import Pages.JobsPage;
import Pages.South_AfricaPage;
import Report.Report;
import Utilities.Utitlites;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTests {

   //private WebDriver driver;
    public static ExtentTest test;
    protected HomePage homePage;

    protected Report report = new Report();

    protected Utitlites utilities = new Utitlites();


    public void ReportSetup(String reportName) throws Exception {
        report.setExtent(report.initializeExtentReports("Automation Run -"));
        test = report.setSub(reportName, report.setMain(reportName));
        test.assignCategory("Regression");
    }

    public void WebDriverSetup(String browser,String url) throws Exception {
        try {
            switch (browser.toUpperCase()) {
                case "CHROME":
                    utilities.WebDriverSetup(utilities.initializeWeDriver("Chrome", url));
                    break;
                case "FIREFOX":
                    utilities.WebDriverSetup(utilities.initializeWeDriver("Firefox", url));
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeClass
    @Parameters({"Test","browser","url"})
    public void setUp(String testName ,String browser,String app) throws Exception {

        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverSetup(browser,app);
            ReportSetup(testName);
            homePage = new HomePage(utilities.getWebDriver());

        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverSetup(browser,app);
            ReportSetup(testName);
            homePage = new HomePage(utilities.getWebDriver());
        }
        //driver.get(app);
        report.ExtentLogPass("HomePage Loaded",utilities.getWebDriver(),test);
    }

    @AfterClass
    public void tearDown() {
        report.getExtent().flush();
        utilities.getWebDriver().quit();
    }
}
