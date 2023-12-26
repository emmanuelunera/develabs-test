package magentoTest.pages;

import magentoTest.AppTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import magentoTest.config.Config;
import magentoTest.config.Wait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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

    private final String cartItem = "//div[@class=\"product-item-details\"]";
    private final String cartItemName = "/strong/a";
    private final String cartItemSize = "//dd[@class=\"values\"][1]";
    private final String cartItemColor = "//dd[@class=\"values\"][2]";
    private final String cartItemExpand = "//div[@class=\"product-item-details\"]//span[@class=\"toggle\" and @aria-expanded=\"false\"]";



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
        Assert.assertTrue(storeLogo.isDisplayed());
    }

    public void gotoSignUpPage() {
        WebElement createAccountHyperlink = wait.forElementToBeDisplayed(20, By.xpath(this.createAnAccountLink));
        createAccountHyperlink.click();
    }

    public void gotoSignInPage() {
        WebElement signInLink = wait.forElementToBeDisplayed(20, By.xpath(this.signInLink));
        signInLink.click();
        wait.forLoading(10);
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
        Assert.assertTrue(cartCount.isDisplayed());

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

    public List<HashMap<String,String>> getCartItemInfo(){
        wait.forLoading(10);
        List<HashMap<String,String>> itemsInfo = new ArrayList<>();
        List<WebElement> items = wait.forElementsToBeDisplayed(10, By.xpath(cartItem));
        for (int i=1; i<= items.size(); ++i){
            HashMap<String,String> itemInfo = new HashMap<>();
            System.out.print(cartItem+"["+i+"]"+cartItemName);
            itemInfo.put("name", driver.findElement(By.xpath("("+cartItem+")["+i+"]"+cartItemName)).getText());
            itemInfo.put("size", driver.findElement(By.xpath("("+cartItem+")["+i+"]"+cartItemSize)).getText());
            itemInfo.put("color", driver.findElement(By.xpath("("+cartItem+")["+i+"]"+cartItemColor)).getText());
            itemsInfo.add(itemInfo);
        }
        return itemsInfo;
    }

}