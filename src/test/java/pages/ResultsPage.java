package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPage {
    WebDriver driver;
    WebDriverWait wait;
    String transmissionType ;

    By NumberOfResultsLocator = By.xpath("//h1[contains(text(),'results for')]");

    private String transmissionXpathTemplate = "//li[@name='Transmission']//input[@aria-label='%s']";


    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getNumberOfResults() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NumberOfResultsLocator)).getText();
    }

    public boolean areSearchResultsDisplayed( String searchContext) {
        return driver.getTitle().contains(searchContext);
    }

    public void applyTransmissionFilter( String transmissionType) {

        driver.findElement(By.xpath(String.format(transmissionXpathTemplate,transmissionType))).click();
    }
}
