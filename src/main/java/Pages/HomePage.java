package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    protected HomePage homePage;
    private By CareerLink = By.id("menu-item-1373");

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }
    public CareersPage Click_CareersLink () {
        driver.findElement(CareerLink).click();
        return new CareersPage(driver);
    }


}
