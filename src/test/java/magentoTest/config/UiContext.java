package magentoTest.config;

import org.openqa.selenium.WebDriver;
import magentoTest.pages.*;

public class UiContext {

    Header header;
    SearchResultsPage searchResultsPage;
    ItemInfoPage itemInfoPage;
    CheckoutShippingPage checkoutShippingPage;

    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Header getHeader() {
        return header;
    }

    public SearchResultsPage getSearchResults() {
        return searchResultsPage;
    }

    public ItemInfoPage getItemInfo() {
        return itemInfoPage;
    }

    public CheckoutShippingPage getCheckoutShippingPage() {
        return checkoutShippingPage;
    }


    public void InitializePages(WebDriver driver) {
        header = new Header(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemInfoPage = new ItemInfoPage(driver);
        checkoutShippingPage = new CheckoutShippingPage(driver);
    }
}
