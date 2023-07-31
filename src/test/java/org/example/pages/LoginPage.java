package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By userNameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginButton = By.id("login-button");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if(!driver.getTitle().equals("Swag Labs")){
            throw new  IllegalStateException("Wrong page!!");
        }
    }
    public LoginPage enterUserName(String username){
        driver.findElement(userNameInputField).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
        return this;
    }
    public MainPage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }
}
