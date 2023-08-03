package org.example;

import org.example.pages.LoginPage;
import org.example.pages.ProductItemPage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;


public class LogoutTest extends BaseTestClass {

    @Test
    public void userLogoutTest() throws MalformedURLException {
        ChromeOptions optionsCHR = new ChromeOptions();
        optionsCHR.setCapability("browserVersion", "114.0");
        optionsCHR.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test userInfo...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true"); }});
            put("enableVNC", true);
        }});
        RemoteWebDriver driverCHR = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsCHR);
        driverCHR.get("https://www.saucedemo.com");

        new LoginPage(driverCHR)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();

        ProductItemPage userLogoutPage = PageFactory.initElements(driverCHR, ProductItemPage.class);
        userLogoutPage.clickOnBurgerMenuBtn();

        userLogoutPage.waitForElementIsInteractable();
        userLogoutPage.userLogout();

        WebElement loginLogo = driverCHR.findElement(By.xpath("//*[text()='standard_user']"));
        Assertions.assertTrue(loginLogo.isDisplayed());

    }
    }

