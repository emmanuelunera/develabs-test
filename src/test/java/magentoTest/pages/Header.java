package magentoTest.pages;

import magentoTest.AppTest;
import org.openqa.selenium.*;
import magentoTest.config.Config;
import magentoTest.config.Wait;

import java.util.HashMap;


public class Header {

    private final String storeLogo = "//a[@aria-label=\"store logo\"]";
    private final String signInLink = "//a[contains(text(),\"Sign In\")]";
    private final String createAnAccountLink = "//a[contains(text(),\"Create an Account\")]";
    private final String searchField = "//input[@id=\"search\"]";
    private final String searchButton = "//button[@class=\"action search\"]";

    private final String cartButton = "//a[@class=\"action showcart\"]";
    private final String cartCount = "//span[@class=\"counter-number\"]";
    private final String cartLoader = "//div[@data-role=\"loader\"]";
    private final String proceedToCheckout = "//button[@title=\"Proceed to Checkout\"]";

    private final String menuItem = "//a[@role=\"menuitem\"]/span[text()=\"*\"]";


    final WebDriver driver;
    final Wait wait;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public void goToSite() {
        Config conf = new Config();
        driver.get(conf.getUiUrl());
        WebElement storeLogo = wait.forElementToBeDisplayed(20, By.xpath(this.storeLogo));
        System.out.print(storeLogo.isDisplayed());
        assert (storeLogo.isDisplayed());
    }

    public void gotoSignUpPage() {
        WebElement createAccountHyperlink = wait.forElementToBeDisplayed(20, By.xpath(this.createAnAccountLink));
        createAccountHyperlink.click();
    }

    public void searchForItem(String item) {
        WebElement searchField = wait.forElementToBeDisplayed(20, By.xpath(this.searchField));
        searchField.click();
        searchField.sendKeys(item);
        WebElement searchButton = wait.forElementToBeDisplayed(20, By.xpath(this.searchButton));
        searchButton.click();
    }

    public void openCartMenu() {
        for(int i = 0; i < 20; ++i){
            if (driver.findElements(By.xpath(cartLoader)).size()==0){
                break;
            }
            wait.forLoading(1);
        }
        WebElement cartButton = wait.forElementToBeDisplayed(20, By.xpath(this.cartButton));
        cartButton.click();

        WebElement cartCount = wait.forElementToBeDisplayed(20, By.xpath(this.cartCount));
        System.out.print(cartCount.getText());
        assert (cartCount.isDisplayed());

    }

    public int getNumberOfCartItems(){
        wait.forLoading(10);
        WebElement cartCount = wait.forElementToBeDisplayed(10, By.xpath(this.cartCount));
        return Integer.parseInt(cartCount.getText());
    }

    public void proceedToCheckout(){
        WebElement proceedToCheckout = wait.forElementToBeDisplayed(20, By.xpath(this.proceedToCheckout));
        proceedToCheckout.click();
    }

}