package org.example;

import org.example.pages.LoginPage;
import org.example.pages.ProductItemPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class CardTestPage extends BaseTestClass {


    @Test
    public void cardInfo()throws MalformedURLException {
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

        ProductItemPage cardInformPage = PageFactory.initElements(driverCHR, ProductItemPage.class);
        cardInformPage.addProductItemToCard(0);
        cardInformPage.clickOnCardButton();
        WebElement productInCard = driverCHR.findElement(By.xpath("//*[@id='item_4_title_link']"));
        Assertions.assertTrue(productInCard.getText().equals("Sauce Labs Backpack"));

    }



}
