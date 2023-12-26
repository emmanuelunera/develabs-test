package magentoTest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import magentoTest.AppTest;
import magentoTest.config.UiContext;
import magentoTest.pages.OrderSuccessPage;
import magentoTest.pages.SignInPage;
import org.junit.Assert;

public class SignInSteps {

    final UiContext uiContext;
    SignInPage signInPage;

    public SignInSteps(UiContext uiContext) {
        this.uiContext = uiContext;
        this.signInPage = uiContext.getSignInPage();
    }

    @Then("user validates saved information is correct")
    public void validateSavedInformation(){
        Assert.assertEquals(signInPage.getEmailField(), AppTest.newUserShippingInfo.get("email"));
        Assert.assertEquals(signInPage.getFirstNameField(), AppTest.newUserShippingInfo.get("firstName"));
        Assert.assertEquals(signInPage.getLastNameField(), AppTest.newUserShippingInfo.get("lastName"));
    }

    @Then("user validates navigation to Sign Up page")
    public void validateNavigationSignUp(){
        Assert.assertEquals("Create New Customer Account", signInPage.validateSignInPage());
    }

    @When("user enters the password {string}")
    public void enterPassword(String password){
        signInPage.enterPassword(password);
    }

    @When("user enters the confirm password {string}")
    public void enterConfirmPassword(String password){
        signInPage.enterConfirmPassword(password);
    }

    @When("user clicks Create Account")
    public void clickCreateAccount(){
        signInPage.clickCreateAccount();
    }

}
