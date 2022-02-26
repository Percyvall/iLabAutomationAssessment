package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage {
    WebDriver driver;
    private By Training_Cert = By.xpath("//h3[normalize-space()='TRAINING & CERTIFICATION']");
    private By Southafrica = By.linkText("South Africa");
    //h3[normalize-space()='TRAINING & CERTIFICATION']
    public CareersPage (WebDriver driver) {
        this.driver = driver;
    }

    public void scrolltoTraining_Certification () {
        WebElement Training_Certificate = driver.findElement(Training_Cert);
        String script = "arguments [0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,Training_Certificate);

    }

    public South_AfricaPage clickSaLink () {
        driver.findElement(Southafrica).click();
        return new South_AfricaPage(driver);

    }

}
