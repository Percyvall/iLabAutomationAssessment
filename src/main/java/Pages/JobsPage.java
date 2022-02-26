package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static java.lang.Integer.toOctalString;


public class JobsPage {
    WebDriver driver;
    private By InterestedTitle = By.xpath("//h4[normalize-space()='Interested?']");
    private By ApplyOnlineButton = By.xpath("//span[@class='wpjb-glyphs wpjb-icon-down-open']");
    private By NameField = By.id("applicant_name");
    private By EmailField = By.id("email");
    private By PhoneField = By.id("phone");
    private By ClickSubmit = By.xpath("//input[@id='wpjb_submit']");
    private By Message = By.xpath("//li[normalize-space()='You need to upload at least one file.']");

    //constructor
    public JobsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void scrollToInterestedTitle() {
        WebElement Interested_Paragraph = driver.findElement(InterestedTitle);
        String script = "arguments [0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, Interested_Paragraph);
    }

    public void ClickApplicationButton() {
        driver.findElement(ApplyOnlineButton).click();
    }

    // fill in form
    public void setFirstName() {
        driver.findElement(NameField).sendKeys("Thokozani");
    }

    public void setEmail() {
        driver.findElement(EmailField).sendKeys("automationAssessment@iLABQuality.com");
    }

    // public void generateNumber () {
    // Random generator = new Random();
    // int i = generator.nextInt(10) + 1;
    // System.out.println(i);

    public String RandomPhone_Number () {

        Random generator = new Random();

        String strippedNum;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        num1 = generator.nextInt(600) + 100;//numbers can't include an 8 or 9, can't go below 100.
        num2 = generator.nextInt(641) + 100;//number has to be less than 742//can't go below 100.
        num3 = generator.nextInt(8999) + 1000; // make numbers 0 through 9 for each digit.//can't go below 1000.

        String string1 = Integer.toString(num1);
        strippedNum = toOctalString(num1);

        return (num1+""+num2+""+num3).toString();
    }



    public void setPhoneField() {
        driver.findElement(PhoneField).sendKeys(RandomPhone_Number());
    }
    public void ClickSubmitButton () {
        driver.findElement(ClickSubmit).click();
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver,11);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='You need to upload at least one file.']")));
    }
    public String getAlertText () {
        return  driver.findElement(Message).getText();
    }

}
