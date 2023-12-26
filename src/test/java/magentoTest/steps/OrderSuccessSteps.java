package magentoTest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import magentoTest.AppTest;
import magentoTest.config.UiContext;
import magentoTest.pages.CheckoutShippingPage;
import magentoTest.pages.OrderSuccessPage;
import org.junit.Assert;

import java.util.Date;

public class OrderSuccessSteps {

    final UiContext uiContext;
    OrderSuccessPage orderSuccessPage;

    public OrderSuccessSteps(UiContext uiContext) {
        this.uiContext = uiContext;
        this.orderSuccessPage = uiContext.getOrderSuccessPage();
    }

    @Then("user validates order is successful")
    public void validateOrderSuccess(){
        Assert.assertEquals(orderSuccessPage.getOrderSuccessTitle(),"Thank you for your purchase!");
        Assert.assertNotEquals("", orderSuccessPage.getOrderNumber());
    }

    @When("user clicks create a new account")
    public void createAccountOnOrderSuccess(){
        orderSuccessPage.clickCreateNewAccount();
    }

}
