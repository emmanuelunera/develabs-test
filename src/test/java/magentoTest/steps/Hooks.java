package magentoTest.steps;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import magentoTest.AppTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import magentoTest.config.*;
import org.openqa.selenium.manager.SeleniumManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;


public class Hooks {

    UiContext uiContext;

    protected static WebDriver driver;

    public Hooks(final UiContext uiContext) {
        this.uiContext = uiContext;
    }

    @BeforeAll
    public static void beforeFeature(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup(Scenario scn){
        driver = setWebDriver();
        uiContext.setDriver(driver);
        uiContext.InitializePages(driver);
        AppTest.cartItemsInfo = new ArrayList<HashMap<String,String>>();
        AppTest.newUserShippingInfo = new HashMap<String,String>();
    }

    public static WebDriver setWebDriver() {
        Config config = new Config();
        switch (config.getBrowser()) {
            case "chrome":
//                System.out.println(System.getProperty("user.dir"));
//                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-dev-shm-usage");
//                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--ignore-certificate-error");
                chromeOptions.addArguments("--enable-features=NetworkService");
//                chromeOptions.addArguments("--user-agent=Chrome/113");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
//                System.setProperty("webdriver.chrome.driver", SeleniumManager.getInstance().getDriverPath(chromeOptions));
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\magentoTest\\config\\chromedriver.exe");

                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + config.getBrowser() + "\" isn't supported.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
        return driver;
    }

    @After
    public void teardown(final Scenario scn) throws IOException {
        WebDriver driver = uiContext.getDriver();

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/src/test/java/resources/screenshots/"+ scn.getName()+".jpg");
        FileUtils.copyFile(srcFile, destFile);

        driver.close();
        driver.quit();
    }
}


