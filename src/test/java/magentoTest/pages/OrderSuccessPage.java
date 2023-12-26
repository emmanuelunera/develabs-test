package magentoTest.pages;

import magentoTest.AppTest;
import magentoTest.config.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderSuccessPage {

    private final String orderSuccessTitle = "//h1/span[@data-ui-id=\"page-title-wrapper\"]";
    private final String orderNumber = "//div[@class=\"checkout-success\"]/p/*";
    private final String continueShoppingButton = "//div[@class=\"actions-toolbar\"]//span[text()=\"Continue Shopping\"]";
    private final String createAccountButton = "//div[@id=\"registration\"]//a";



    final WebDriver driver;
    final Wait wait;

    public OrderSuccessPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public String getOrderSuccessTitle(){
        wait.forLoading(5);
        WebElement successTitle = wait.forElementToBeDisplayed(10, By.xpath(this.orderSuccessTitle));
        return successTitle.getText();
    }

    public String getOrderNumber(){
        wait.forLoading(10);
        WebElement orderNumber = wait.forElementToBeDisplayed(10, By.xpath(this.orderNumber));
        System.out.print(orderNumber.getText());
        AppTest.orderNumber = orderNumber.getText();
        return orderNumber.getText();
    }

    public void clickCreateNewAccount(){
        WebElement createAccountButton = wait.forElementToBeDisplayed(10, By.xpath(this.createAccountButton));
        createAccountButton.click();
    }

    public void clickContinueShopping(){
        WebElement continueShoppingButton = wait.forElementToBeDisplayed(10, By.xpath(this.continueShoppingButton));
        continueShoppingButton.click();
    }

}