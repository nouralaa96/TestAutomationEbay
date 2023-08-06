package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ExtentReport {

        private static ExtentReports extent;
        protected static ExtentTest test;

        @BeforeSuite
        public static void setUp() {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }


    @AfterMethod
        public void afterMethod(ITestResult result) {
            if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test passed");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                test.fail("Test failed");
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("Test skipped");
            }
        }

        @AfterSuite
        public static void tearDowns() {
            extent.flush();
        }
    }


