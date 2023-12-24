package magentoTest.pages;

import magentoTest.AppTest;
import magentoTest.config.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;


public class ItemInfoPage {

    private final String itemTitle = "//h1/span[@itemprop=\"name\"]";
    private final String resultLink = "//a[@class=\"product-item-link\" and contains(text(),\"*\")]";

    private final String itemSize = "//div[@class=\"swatch-attribute size\"]//div[text()=\"*\"]";
    private final String itemColor = "//div[@class=\"swatch-attribute color\"]//div[@aria-label=\"*\"]";
    private final String itemQuantity = "//input[@name=\"qty\"]";
    private final String addToCart = "//button[@title=\"Add to Cart\"]";



    final WebDriver driver;
    final Wait wait;

    public ItemInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public String getItemTitle(){
        WebElement itemTitle = wait.forElementToBeDisplayed(10, By.xpath(this.itemTitle));
        return itemTitle.getText();
    }

   public void selectItemSize(String size){
       AppTest.currentItemInfo.put("size", size);
       WebElement itemSizeButton = wait.forElementToBeDisplayed(10, By.xpath(this.itemSize.replace("*", size)));
       itemSizeButton.click();

   }

    public void selectItemColor(String color){
        AppTest.currentItemInfo.put("color", color);
        WebElement itemColor = wait.forElementToBeDisplayed(10, By.xpath(this.itemColor.replace("*", color)));
        itemColor.click();
    }

    public void setItemQuantity(String quantity){
        AppTest.currentItemInfo.put("quantity", quantity);
        WebElement itemQuantity = wait.forElementToBeDisplayed(10, By.xpath(this.itemQuantity));
        itemQuantity.clear();
        itemQuantity.sendKeys(quantity);
    }

    public void addItemToCart(){
        WebElement addToCart = wait.forElementToBeDisplayed(10, By.xpath(this.addToCart));
        addToCart.click();
        AppTest.cartItemsInfo.add(AppTest.currentItemInfo);
        AppTest.currentCartCount = AppTest.currentCartCount + Integer.parseInt(AppTest.currentItemInfo.get("quantity"));
    }


}