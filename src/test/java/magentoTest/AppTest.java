package magentoTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Unit tests for simple App.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/destination/cucumber.json", "pretty", "html:target/cucumber-reports/report.html"},
        glue = { "classpath:magentoTest/steps"}
        )
public class AppTest {
        public static String searchQuery = "";
        public static Integer currentCartCount = 0;
        public static HashMap<String, String> currentItemInfo;
        public static ArrayList<HashMap<String, String>> cartItemsInfo;
}
