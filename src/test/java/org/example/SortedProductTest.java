package org.example;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
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
            put("name", "Test userInfo...");

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
        ArrayList<String> Prices1 = new ArrayList<>();

        ArrayList<String> sortedPrices = new ArrayList<>(Prices1);
        Collections.sort(sortedPrices);

        Select s = new Select(driverCHR.findElement(By.cssSelector("[class='product_sort_container']")));
        s.selectByValue("lohi");

        List<WebElement> table2 = driverCHR.findElements(By.cssSelector(".inventory_item_price"));
        ArrayList<String> Prices2 = new ArrayList<>();

        Assertions.assertEquals(Prices2, Prices1, "Should be sorted from lower to highest price");
    }
}




