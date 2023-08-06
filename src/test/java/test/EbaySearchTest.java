package test;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.EbayMainPage;
import pages.ResultsPage;
import utilities.ExtentReport;
import utilities.ReadJsonData;

import java.io.IOException;

public class EbaySearchTest extends ExtentReport  {
    WebDriver driver;
    EbayMainPage ebayMainPage;
    ResultsPage resultsPage;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ebayMainPage = new EbayMainPage(driver);
        resultsPage = new ResultsPage(driver);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validateNavigationToEbay() throws IOException, ParseException {

        ebayMainPage.navigateToEbay(ReadJsonData.getTestData("url"));
        Assert.assertTrue(ebayMainPage.isMainPageDisplayed());

    }

    @Test
    public void validateResults() throws IOException, ParseException {

        ebayMainPage.searchForItem(ReadJsonData.getTestData("Search Item"));
        Assert.assertTrue(resultsPage.areSearchResultsDisplayed(ReadJsonData.getTestData("Search Item")));
        System.out.println(resultsPage.getNumberOfResults());
        test.info("Number of search results: " + resultsPage.getNumberOfResults());
        resultsPage.applyTransmissionFilter(ReadJsonData.getTestData("Transmission Type"));
    }
}
