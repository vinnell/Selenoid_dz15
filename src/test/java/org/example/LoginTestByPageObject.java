package org.example;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class LoginTestByPageObject extends BaseTestClass{

    @Test
    public void verifyLogin() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserVersion", "115.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test login...");
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
        boolean loginIsSuccess = new LoginPage(driverFF)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton()
                .getMainContentVisibility();

        Assertions.assertTrue(loginIsSuccess);
/////////////////////////////////////////////////////////////////////////
        ChromeOptions optionsCHR = new ChromeOptions();
        optionsCHR.setCapability("browserVersion", "114.0");
        optionsCHR.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test login...");
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

        boolean loginIsSuccessCHR = new LoginPage(driverCHR)
               .enterUserName("standard_user")
               .enterPassword("secret_sauce")
               .clickOnLoginButton()
               .getMainContentVisibility();

        Assertions.assertTrue(loginIsSuccess);


    }
}
