package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    @Test
    public void openLoginPage() {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://the-internet.herokuapp.com/login");
        String title = chromeDriver.getTitle();
        Assertions.assertEquals("The Internet", title);
        WebElement usernameField = chromeDriver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        WebElement passwordField = chromeDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = chromeDriver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement welcomePage = chromeDriver.findElement(By.id("flash"));
        Assertions.assertTrue(welcomePage.isDisplayed());

        chromeDriver.quit();
    }
    @Test
    public void wrongPassword(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameFieldCorrect = chromeDriver.findElement(By.id("username"));
        usernameFieldCorrect.sendKeys("tomsmith");
        WebElement passwordFieldWrong = chromeDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordFieldWrong.sendKeys("supersecretpassword!");

        WebElement loginButton1 = chromeDriver.findElement(By.xpath("//button[@type='submit']"));
        loginButton1.click();

        WebElement messageForWrongPassword = chromeDriver.findElement(By.id("flash"));
        Assertions.assertTrue(messageForWrongPassword.isDisplayed());

        chromeDriver.quit();
    }
}
