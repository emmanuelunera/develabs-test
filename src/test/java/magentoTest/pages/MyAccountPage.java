package magentoTest.pages;

import magentoTest.config.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MyAccountPage {

    private final String myAccountTitle = "//h1/span[@data-ui-id=\"page-title-wrapper\"]";

    private final String successBanner = "//div[@role=\"alert\"]";

    private final String tableRows = "//table[@id=\"my-orders-table\"]/tbody/tr";
    private final String orderNumber = "//table[@id=\"my-orders-table\"]/tbody/tr[*]/td[@data-th=\"Order #\"]";
    private final String orderDate = "//table[@id=\"my-orders-table\"]/tbody/tr[*]/td[@data-th=\"Order #\"]";
    private final String orderShipTo = "//table[@id=\"my-orders-table\"]/tbody/tr[*]/td[@data-th=\"Ship To\"]";



    final WebDriver driver;
    final Wait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public String validateMyAccountPage(){
        WebElement signInTitle = wait.forElementToBeDisplayed(10, By.xpath(this.myAccountTitle));
        return signInTitle.getText();
    }

    public String getBannerText(){
        wait.forLoading(10);
        WebElement successBanner = wait.forElementToBeDisplayed(10, By.xpath(this.successBanner));
        return successBanner.getText();
    }

    public List<HashMap<String, String>> getRecentOrderInfo(){
        List<HashMap<String, String>> ordersInfo = new ArrayList<>();

        for(int i = 1; i <= wait.forElementsToBeDisplayed(10, By.xpath(tableRows)).size(); ++i){
            HashMap<String, String> orderInfo = new HashMap<>();
            orderInfo.put("orderNumber", wait.forElementToBeDisplayed(10, By.xpath(orderNumber.replace("*",String.valueOf(i)))).getText());
            orderInfo.put("orderDate", wait.forElementToBeDisplayed(10, By.xpath(orderDate.replace("*",String.valueOf(i)))).getText());
            orderInfo.put("orderShipTo", wait.forElementToBeDisplayed(10, By.xpath(orderNumber.replace("*",String.valueOf(i)))).getText());
            ordersInfo.add(orderInfo);
        }
        return ordersInfo;
    }
}