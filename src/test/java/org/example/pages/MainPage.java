package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    private By mainContent = By.xpath("//*[@id='page_wrapper']");

    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean getMainContentVisibility(){
       return webDriver.findElement(mainContent).isDisplayed();}
      }

