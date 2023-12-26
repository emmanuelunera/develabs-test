package magentoTest.steps;

import io.cucumber.java.en.*;
import magentoTest.AppTest;
import magentoTest.config.UiContext;
import magentoTest.pages.CheckoutShippingPage;
import magentoTest.pages.Header;
import org.junit.Assert;

import java.util.Date;

public class ShippingInfoSteps {

    final UiContext uiContext;
    CheckoutShippingPage checkoutShippingPage;

    public ShippingInfoSteps(UiContext uiContext) {
        this.uiContext = uiContext;
        this.checkoutShippingPage = uiContext.getCheckoutShippingPage();
    }

    @Then("user validates navigation to the shipping info page")
    public void validateNavigationToShipping(){
        Assert.assertEquals(checkoutShippingPage.validateShippingPage(),"Shipping Address");
    }

    @When("user fills up shipping info {string} field with {string}")
    public void enterShippingField(String field, String value){
        if(field.equalsIgnoreCase("email address")){
            checkoutShippingPage.enterEmail(value);
        } else if (field.equalsIgnoreCase("first name")) {
            checkoutShippingPage.enterFirstName(value);
        } else if (field.equalsIgnoreCase("last name")) {
            checkoutShippingPage.enterLastName(value);
        } else if (field.equalsIgnoreCase("company")) {
            checkoutShippingPage.enterCompany(value);
        } else if (field.equalsIgnoreCase("street address")) {
            checkoutShippingPage.enterStreetAddress(value);
        } else if (field.equalsIgnoreCase("city")) {
            checkoutShippingPage.enterCity(value);
        } else if (field.equalsIgnoreCase("state")) {
            checkoutShippingPage.enterState(value);
        } else if (field.equalsIgnoreCase("country")) {
            checkoutShippingPage.enterCountry(value);
        } else if (field.equalsIgnoreCase("phone number")) {
            checkoutShippingPage.enterPhoneNumber(value);
        } else if (field.equalsIgnoreCase("zip code")) {
            checkoutShippingPage.enterZip(value);
        } else{
            System.out.print("invalid field name");
        }
    }

    @When("user fills up shipping info email field with unique email")
    public void enterShippingField(){
        Date date = new Date();
        String email = "emman+" + date.getTime()  + "@gmail.com";
        enterShippingField("email address", email);
    }

    @When("user selects the {string} shipping method")
    public void selectShippingMethod(String shippingMethod){
        checkoutShippingPage.selectShippingMethod(shippingMethod);
    }


    @When("user clicks next button to the review page")
    public void clickNextButton(){
        checkoutShippingPage.clickNextButton();
    }

    @When("user clicks place order")
    public void clickPlaceOrder(){
        checkoutShippingPage.clickPlaceOrder();
    }

    @Then("user validates shipping info")
    public void validateShippingInfo(){
        String reviewInfo = checkoutShippingPage.getShippingInfoReview();
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("firstName")));
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("lastName")));
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("street")));
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("city")));
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("state")));
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("zipCode")));
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("country")));
        Assert.assertTrue(reviewInfo.contains(AppTest.newUserShippingInfo.get("phone")));
    }

}
