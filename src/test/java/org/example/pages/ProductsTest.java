package org.example.pages;

import org.example.BaseTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductsTest extends BaseTestClass {

    @Test
    public void productInfo()throws MalformedURLException {
        ChromeOptions optionsCHR = new ChromeOptions();
        optionsCHR.setCapability("browserVersion", "114.0");
        optionsCHR.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test Product Item Page...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVNC", true);
        }});
        RemoteWebDriver driverCHR = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsCHR);
        driverCHR.get("https://www.saucedemo.com");

        new LoginPage(driverCHR)
                        .enterUserName("standard_user")
                        .enterPassword("secret_sauce")
                        .clickOnLoginButton();

        ProductItemPage productInformPage = PageFactory.initElements(driverCHR, ProductItemPage.class);
        Assertions.assertEquals("$29.99", productInformPage.getPriceOfProducts(0));
        Assertions.assertEquals("Sauce Labs Backpack", productInformPage.getTitleOfProducts(0));
    //////////////////////////////////////////////////////////////
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserVersion", "115.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test Product Item Page...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVNC", true);
        }});
        RemoteWebDriver driverFF = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driverFF.get("https://www.saucedemo.com");
        new LoginPage(driverFF)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();

        ProductItemPage productInformPageFF = PageFactory.initElements(driverFF, ProductItemPage.class);
        Assertions.assertEquals("$29.99", productInformPage.getPriceOfProducts(0));
        Assertions.assertEquals("Sauce Labs Backpack", productInformPage.getTitleOfProducts(0));
    }



}
