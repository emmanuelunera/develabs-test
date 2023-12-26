package magentoTest.pages;

import magentoTest.AppTest;
import magentoTest.config.Wait;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CheckoutShippingPage {

    private final String shippingTitle = "//div[@class=\"step-title\"][1]";

    private final String emailField = "//div[@id=\"checkout-step-shipping\"]//input[@id=\"customer-email\"]";
    private final String firstNameField = "//input[@name=\"firstname\"]";
    private final String lastNameField = "//input[@name=\"lastname\"]";
    private final String companyField = "//input[@name=\"company\"]";
    private final String streetAddressField = "//input[@name=\"street[0]\"]";
    private final String cityField = "//input[@name=\"city\"]";
    private final String stateDropdown = "//div[@name=\"shippingAddress.region_id\"]//select";
    private final String zipCodeField = "//input[@name=\"postcode\"]";
    private final String countryDropdown = "//select[@name=\"country_id\"]";
    private final String phoneNumberField = "//input[@name=\"telephone\"]";

    private final String shippingMethod = "//td[text()=\"*\"]//parent::tr//input";

    private final String nextButton = "//button[@data-role=\"opc-continue\"]";
    private final String dropdownOption = "//option[@data-title=\"*\"]";
    private final String shippingInfoReview = "//div[@class=\"billing-address-details\"]";

    private final String placeOrderButton = "//button[@class=\"action primary checkout\"]";

    final WebDriver driver;
    final Wait wait;

    public CheckoutShippingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public String validateShippingPage(){
        WebElement shippingTitle = wait.forElementToBeDisplayed(10, By.xpath(this.shippingTitle));
        return shippingTitle.getText();
    }

    public void enterEmail(String email){
        wait.forLoading(10);
        WebElement emailField = wait.forElementToBeDisplayed(10, By.xpath(this.emailField));
        emailField.clear();
        emailField.sendKeys(email);
        wait.forLoading(3);
        AppTest.newUserShippingInfo.put("email", email);
    }

    public void enterFirstName(String name){
        WebElement firstNameField = wait.forElementToBeDisplayed(10, By.xpath(this.firstNameField));
        firstNameField.clear();
        firstNameField.sendKeys(name);
        AppTest.newUserShippingInfo.put("firstName", name);
    }

    public void enterLastName(String name){
        WebElement lastNameField = wait.forElementToBeDisplayed(10, By.xpath(this.lastNameField));
        lastNameField.clear();
        lastNameField.sendKeys(name);
        AppTest.newUserShippingInfo.put("lastName", name);
    }

    public void enterCompany(String company){
        WebElement companyField = wait.forElementToBeDisplayed(10, By.xpath(this.companyField));
        companyField.clear();
        companyField.sendKeys(company);
        AppTest.newUserShippingInfo.put("company", company);
    }

    public void enterStreetAddress(String address){
        WebElement streetAddressField = wait.forElementToBeDisplayed(10, By.xpath(this.streetAddressField));
        streetAddressField.clear();
        streetAddressField.sendKeys(address);
        AppTest.newUserShippingInfo.put("street", address);
    }

    public void enterCity(String city){
        WebElement cityField = wait.forElementToBeDisplayed(10, By.xpath(this.cityField));
        cityField.clear();
        cityField.sendKeys(city);
        AppTest.newUserShippingInfo.put("city", city);
    }

    public void enterState(String state){
        WebElement stateDropdown = wait.forElementToBeDisplayed(10, By.xpath(this.stateDropdown));
        stateDropdown.click();
        WebElement stateOption = wait.forElementToBeDisplayed(10, By.xpath(this.dropdownOption.replace("*",state)));
        stateOption.click();
        wait.forLoading(5);
        AppTest.newUserShippingInfo.put("state", state);
    }

    public void enterZip(String zip){
        WebElement zipCodeField = wait.forElementToBeDisplayed(10, By.xpath(this.zipCodeField));
        zipCodeField.clear();
        zipCodeField.sendKeys(zip);
        AppTest.newUserShippingInfo.put("zipCode", zip);
    }

    public void enterCountry(String country){
        WebElement countryDropdown = wait.forElementToBeDisplayed(10, By.xpath(this.countryDropdown));
        countryDropdown.click();
        WebElement stateOption = wait.forElementToBeDisplayed(10, By.xpath(this.dropdownOption.replace("*", country)));
        stateOption.click();
        wait.forLoading(5);
        AppTest.newUserShippingInfo.put("country", country);
    }

    public void enterPhoneNumber(String phone){
        WebElement phoneNumberField = wait.forElementToBeDisplayed(10, By.xpath(this.phoneNumberField));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phone);
        AppTest.newUserShippingInfo.put("phone", phone);
    }

    public void selectShippingMethod(String method){
        WebElement shippingMethodRadio = wait.forElementToBeDisplayed(10, By.xpath(this.shippingMethod.replace("*",method)));
        shippingMethodRadio.click();
    }

    public void clickNextButton(){
        WebElement nextButton = wait.forElementToBeDisplayed(10, By.xpath(this.nextButton));
        nextButton.click();
    }

    public void clickPlaceOrder(){
        WebElement placeOrderButton = wait.forElementToBeDisplayed(10, By.xpath(this.placeOrderButton));
        wait.forLoading(10);
        placeOrderButton.click();
    }

    public String getShippingInfoReview(){
        wait.forLoading(10);
        return wait.forElementToBeDisplayed(10, By.xpath(this.shippingInfoReview)).getText();
    }
}