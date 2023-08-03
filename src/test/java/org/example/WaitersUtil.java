package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitersUtil {
    public static WebElement explicitWait(WebDriver webDriver, By by){
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
