package magentoTest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import magentoTest.AppTest;
import magentoTest.config.UiContext;
import magentoTest.pages.ItemInfoPage;
import magentoTest.pages.SearchResultsPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemInfoSteps {

    final UiContext uiContext;
    ItemInfoPage itemInfoPage;

    public ItemInfoSteps(UiContext uiContext) {
        this.uiContext = uiContext;
        this.itemInfoPage = uiContext.getItemInfo();
    }

    @When("user sets the item size to {string}")
    public void setItemSize(String size){
        itemInfoPage.selectItemSize(size);
    }

    @When("user sets the item color to {string}")
    public void setItemColor(String color){
        itemInfoPage.selectItemColor(color);
    }

    @When("user sets the item quantity to {string}")
    public void setItemQuantity(String quantity){
        itemInfoPage.setItemQuantity(quantity);
    }

    @When("user adds item to cart")
    public void addItemToCart(){
        itemInfoPage.addItemToCart();
    }



}
