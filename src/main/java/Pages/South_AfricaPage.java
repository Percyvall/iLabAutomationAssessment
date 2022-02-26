package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class South_AfricaPage {
    WebDriver driver;
    private By jobFirstLink = By.xpath("//a[contains(text(),'Interns - BSC Computer Science, National Diploma: ')]");

    public South_AfricaPage (WebDriver driver) {
        this.driver = driver;
    }
    public JobsPage clickJobFirstLink () {
    driver.findElement(jobFirstLink).click();
    return new JobsPage(driver);
    }
}
