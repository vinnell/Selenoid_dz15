package org.example;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class SortedProductTest extends BaseTestClass {

    @Test
    public void sortedProductPage() throws MalformedURLException {
        ChromeOptions optionsCHR = new ChromeOptions();
        optionsCHR.setCapability("browserVersion", "114.0");
        optionsCHR.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test Sorted Product Page...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVNC", true);
        }});
        RemoteWebDriver driverCHR = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsCHR);
        driverCHR.get("https://www.saucedemo.com");

        new LoginPage(driverCHR)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();

        List<WebElement> table = driverCHR.findElements(By.cssSelector(".inventory_item_price"));
        ArrayList<String> prices1 = new ArrayList<>();

        ArrayList<String> sortedPrices = new ArrayList<>(prices1);
        Collections.sort(sortedPrices);

        Select s = new Select(driverCHR.findElement(By.cssSelector("[class='product_sort_container']")));
        s.selectByValue("lohi");

        List<WebElement> table2 = driverCHR.findElements(By.cssSelector(".inventory_item_price"));
        ArrayList<String> prices2 = new ArrayList<>();

        Assertions.assertEquals(prices2, prices1, "Should be sorted from lower to highest price");
        //////////////////////////////////////////////////////////////////////////
//        FirefoxOptions options = new FirefoxOptions();
//        options.setCapability("browserVersion", "115.0");
//        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            put("name", "Test Sorted Product Page...");
//            put("sessionTimeout", "15m");
//            put("env", new ArrayList<String>() {{
//                add("TZ=UTC");
//            }});
//            put("labels", new HashMap<String, Object>() {{
//                put("manual", "true");
//            }});
//            put("enableVNC", true);
//        }});
//        RemoteWebDriver driverFF = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//        driverFF.get("https://www.saucedemo.com");
//        new LoginPage(driverFF)
//                .enterUserName("standard_user")
//                .enterPassword("secret_sauce")
//                .clickOnLoginButton();
//        List<WebElement> table3 = driverFF.findElements(By.cssSelector(".inventory_item_price"));
//        ArrayList<String> prices3 = new ArrayList<>();
//
//        ArrayList<String> sortedPrices3 = new ArrayList<>(prices3);
//        Collections.sort(sortedPrices3);
//
//        Select s3 = new Select(driverFF.findElement(By.cssSelector("[class='product_sort_container']")));
//        s3.selectByValue("lohi");
//
//        List<WebElement> table4 = driverFF.findElements(By.cssSelector(".inventory_item_price"));
//        ArrayList<String> prices4 = new ArrayList<>();
//
//        Assertions.assertEquals(prices4, prices3, "Should be sorted from lower to highest price");
    }
}




