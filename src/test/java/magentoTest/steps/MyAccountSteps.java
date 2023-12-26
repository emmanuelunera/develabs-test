package magentoTest.steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import magentoTest.AppTest;
import magentoTest.config.UiContext;
import magentoTest.pages.MyAccountPage;
import magentoTest.pages.SignInPage;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAccountSteps {

    final UiContext uiContext;
    MyAccountPage myAccountPage;

    public MyAccountSteps(UiContext uiContext) {
        this.uiContext = uiContext;
        this.myAccountPage = uiContext.getMyAccountPage();
    }

    @Then("user validates account creation")
    public void validateSavedInformation(){
        String thanksBanner = myAccountPage.getBannerText();
        Assert.assertTrue(thanksBanner.contains("Thank you for registering"));
    }

    @Then("user validates order is in the list")
    public void validateOrderInList(){
        List<HashMap<String, String>> ordersInfo = myAccountPage.getRecentOrderInfo();
        Boolean checker = false;
        for (HashMap<String,String> orderRow: ordersInfo){
            if(orderRow.get("orderNumber").equals(AppTest.orderNumber)){
                checker = true;
                break;
            }
        }
        Assert.assertTrue(checker);
    }

    @Then("user validates navigation to my account page")
    public void validateNavigateMyAccount(){
        Assert.assertEquals(myAccountPage.getMyAccountTitle(), "My Account");
    }
}
