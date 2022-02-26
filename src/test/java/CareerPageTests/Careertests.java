package CareerPageTests;

import Pages.CareersPage;
import Pages.JobsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class Careertests extends BaseTests {
    @Test
    public void Test_CareerLink () {
        CareersPage careersPage = homePage.Click_CareersLink();
        careersPage.scrolltoTraining_Certification();
        careersPage.clickSaLink();

        JobsPage jobsPage = saPage.clickJobFirstLink();
        jobsPage.scrollToInterestedTitle();
        jobsPage.ClickApplicationButton();
        jobsPage.setFirstName();
        jobsPage.setEmail();
        jobsPage.setPhoneField();
        jobsPage.ClickSubmitButton();
        assertEquals(jobsPage.getAlertText(),"You need to upload at least one file.","Alert text incorrect");

    }


}
