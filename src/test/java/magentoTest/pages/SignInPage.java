package magentoTest.pages;

import magentoTest.config.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SignInPage {

    private final String signInTitle = "//h1/span[@data-ui-id=\"page-title-wrapper\"]";

    private final String firstNameField = "//input[@id=\"firstname\"]";
    private final String lastNameField = "//input[@id=\"lastname\"]";
    private final String emailField = "//input[@name=\"email\"]";
    private final String passwordField = "//input[@title=\"Password\"]";
    private final String confirmPasswordField = "//input[@title=\"Confirm Password\"]";
    private final String createAccountButton = "//button[@title=\"Create an Account\"]";


    final WebDriver driver;
    final Wait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public String validateSignInPage(){
        WebElement signInTitle = wait.forElementToBeDisplayed(10, By.xpath(this.signInTitle));
        return signInTitle.getText();
    }

    public void enterFirstName(String name){
        WebElement firstNameField = wait.forElementToBeDisplayed(10, By.xpath(this.firstNameField));
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void enterLastName(String name){
        WebElement lastNameField = wait.forElementToBeDisplayed(10, By.xpath(this.lastNameField));
        lastNameField.clear();
        lastNameField.sendKeys(name);
    }

    public void enterEmail(String email){
        WebElement emailField = wait.forElementToBeDisplayed(10, By.xpath(this.emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordField = wait.forElementToBeDisplayed(10, By.xpath(this.passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String password){
        WebElement confirmPasswordField = wait.forElementToBeDisplayed(10, By.xpath(this.confirmPasswordField));
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(password);
    }

    public String getFirstNameField(){
        WebElement firstNameField = wait.forElementToBeDisplayed(10, By.xpath(this.firstNameField));
        return firstNameField.getAttribute("value");
    }

    public String getLastNameField(){
        WebElement lastNameField = wait.forElementToBeDisplayed(10, By.xpath(this.lastNameField));
        return lastNameField.getAttribute("value");
    }

    public String getEmailField(){
        WebElement emailField = wait.forElementToBeDisplayed(10, By.xpath(this.emailField));
        return emailField.getAttribute("value");
    }

    public void clickCreateAccount(){
        WebElement createAccountButton = wait.forElementToBeDisplayed(10, By.xpath(this.createAccountButton));
        createAccountButton.click();
    }


}