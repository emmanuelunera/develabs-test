package magentoTest.steps;

import io.cucumber.java.en.*;
import magentoTest.AppTest;
import magentoTest.config.UiContext;
import magentoTest.pages.Header;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

public class LandingSteps {

    final UiContext uiContext;
    Header header;

    public LandingSteps(UiContext uiContext) {
        this.uiContext = uiContext;
        this.header = uiContext.getHeader();
    }

    @Given("user opens the site")
    public void userOpenSite() {
        header.goToSite();
    }

    @When("user searches for {string}")
    public void searchItem(String item){
        header.searchForItem(item);
    }

    @When("user opens the cart menu")
    public void openCartMenu(){
        header.openCartMenu();
    }


    @When("user proceeds to checkout page")
    public void proceedToCheckout(){
        header.proceedToCheckout();
    }


    @Then("user validates count of items in the cart")
    public void userValidatesCountOfItemsInTheCart() {
        Integer actual = header.getNumberOfCartItems();
        Integer expected = 0;
        for(HashMap<String, String> item: AppTest.cartItemsInfo){
            expected = expected + Integer.parseInt(item.get("quantity"));
        }
        Assert.assertEquals(actual,expected);
    }

    @Then("user validates items in the cart")
    public void userValidatesCartItems(){
        List<HashMap <String,String>> itemsInfo = header.getCartItemInfo();
        for (HashMap<String,String> cartItemInfo: itemsInfo){
            System.out.print(cartItemInfo);
        }
    }
}
