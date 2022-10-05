package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

public class Report{

    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest extentTest;
    public static ExtentTest mainTest;
    public static ExtentTest subTest;


    public ExtentReports initializeExtentReports(String sReportName) {

        String sDefaultPath = System.getProperty("user.dir");

        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/report/" + sReportName + getCurrentTimeStamp() + ".html");

        extent = new ExtentReports();
        extent.setSystemInfo("HTML Report", "Regression");
        extent.attachReporter(spark);

        return extent;
    }

    public String getCurrentTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf.format(timestamp);

    }

    public void setExtent(ExtentReports extentTest) {
        Report.extent = extentTest;
    }

    public void setExtentTest(ExtentTest extentTest) {
        Report.extentTest = extentTest;
    }

    public ExtentTest setMain(String parentName) {
        mainTest = extent.createTest(parentName);
        return mainTest;
    }

    public ExtentTest setSub(String childName, ExtentTest parentName) {
        subTest = parentName.createNode(childName);
        return subTest;
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public ExtentTest getExtentTest() {
        return extentTest;
    }

    public void ExtentLogPass(String sMessagePass, WebDriver driver, ExtentTest test) throws Exception {
        String fileName = CaptureScreenWin(driver);
        test.pass(sMessagePass, MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
    }

    public void ExtentLogFail(String sMessageFail, WebDriver driver, ExtentTest test) throws Exception {
        String fileName = CaptureScreenWin(driver);
        test.fail(sMessageFail, MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
        driver.quit();
    }

    public void ExtentLogInfo(String sMessageInfo, ExtentTest test) throws Exception {
        test.info(sMessageInfo);
    }

    public String CaptureScreenWin(WebDriver driver) throws IOException {

        File scrImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(scrImage)));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

}

