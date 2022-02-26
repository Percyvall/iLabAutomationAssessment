package CareerPageTests;


import Pages.JobsPage;
import org.openqa.selenium.WebDriver;

public class test_function extends JobsPage {

    static WebDriver driver;

    static JobsPage page = new JobsPage(driver);
    public test_function(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args){
        String Phone = page.RandomPhone_Number();

        System.out.println(Phone);
    }
}
