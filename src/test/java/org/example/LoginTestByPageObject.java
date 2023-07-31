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
            /* How to add test badge */
            put("name", "Test login...");

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

//            /* How to enable video recording */
//            put("enableVideo", true);
            put("enableVNC", true);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        //chromeDriver.get("https://www.saucedemo.com");
        driver.get("https://www.saucedemo.com");
/////////////////////////////////////////////////////////////////////////
        ChromeOptions optionsCHR = new ChromeOptions();
        optionsCHR.setCapability("browserVersion", "114.0");
        optionsCHR.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

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

        boolean loginIsSuccess = new LoginPage(driverCHR)
               .enterUserName("standard_user")
               .enterPassword("secret_sauce")
               .clickOnLoginButton()
               .getMainContentVisibility();

        Assertions.assertTrue(loginIsSuccess);


    }
}
