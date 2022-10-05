package CareerPageTests;

import Pages.CareersPage;
import Pages.JobsPage;
import Pages.South_AfricaPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class Careertests extends BaseTests {
    @Test
    public void Test_CareerLink () throws Exception {

        try {
            CareersPage careersPage = homePage.Click_CareersLink();
            careersPage.scrolltoTraining_Certification();
            South_AfricaPage saPage = careersPage.clickSaLink();

            JobsPage jobsPage = saPage.clickJobFirstLink();
            jobsPage.scrollToInterestedTitle();
            jobsPage.ClickApplicationButton();
            jobsPage.setFirstName();
            jobsPage.setEmail();
            jobsPage.setPhoneField();
            jobsPage.ClickSubmitButton();
            assertEquals(jobsPage.getAlertText(), "You need to upload at least one file.", "Alert text incorrect");
        }catch (Exception e){
            report.ExtentLogFail("Failed to complete Career Test : "+e.getMessage(),utilities.getWebDriver(),test);
        }
    }


}
