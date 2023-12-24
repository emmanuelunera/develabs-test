package magentoTest.pages;

import magentoTest.AppTest;
import magentoTest.config.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;


public class SearchResultsPage {

    private final String pageTitle = "//h1/span[@data-ui-id=\"page-title-wrapper\"]";
    private final String resultLink = "//a[@class=\"product-item-link\" and contains(text(),\"*\")]";


    final WebDriver driver;
    final Wait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public String getTitle() {
        WebElement pageTitle = wait.forElementToBeDisplayed(10, By.xpath(this.pageTitle));
        return pageTitle.getText();
    }

    public List<WebElement> getListOfResults() {
        List<WebElement> results = wait.forElementsToBeDisplayed(20, By.xpath(this.resultLink.replace("*", AppTest.searchQuery)));
        return results;
    }

    public void openResultWithName(String itemName){
        AppTest.currentItemInfo = new HashMap<>();
        AppTest.currentItemInfo.put("name", itemName);
        WebElement resultLink = wait.forElementToBeDisplayed(10, By.xpath(this.resultLink.replace("*", itemName)));
        resultLink.click();
    }



}