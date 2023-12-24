package magentoTest.steps;

import io.cucumber.java.en.*;
import magentoTest.AppTest;
import magentoTest.config.UiContext;
import magentoTest.pages.SearchResultsPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsSteps {

    final UiContext uiContext;
    SearchResultsPage searchResultsPage;

    public SearchResultsSteps(UiContext uiContext) {
        this.uiContext = uiContext;
        this.searchResultsPage = uiContext.getSearchResults();
    }

    @Then("user validate search results")
    public void searchItem(){
        String pageTitle = searchResultsPage.getTitle();
        assert pageTitle.contains(AppTest.searchQuery);
        List<WebElement> results = searchResultsPage.getListOfResults();
        for (WebElement result: results){
            Assert.assertTrue(result.getText().contains(AppTest.searchQuery));
        }
    }

    @When("user opens the {string} item")
    public void openItem(String itemName){
        searchResultsPage.openResultWithName(itemName);
    }
}
