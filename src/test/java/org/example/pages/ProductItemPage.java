package org.example.pages;

import org.example.pages.components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductItemPage {
    public WebDriver driver;

    public ProductItemPage() {
    }

    public ProductItemPage(List<WebElement> products) {
    }

    public ProductItemPage(WebDriver driver) {
        this.driver = driver;
    }


    private By cardButton = By.xpath("//*[@class='shopping_cart_badge']");
    @FindBy(xpath = "//*[@class='inventory_item']")
    private List<WebElement> products;
    private By burgerMenuBtn = By.xpath("//*[@id='react-burger-menu-btn']");
    private By logoutBtn = By.xpath("//*[@id='logout_sidebar_link']");
    private By userNameInputField = By.id("user-name");


    public ProductItemPage(WebElement products) {
        PageFactory.initElements(products, this);
    }

    public String getTitleOfProducts(int idOfProduct) {
        return new ProductComponent(products.get(idOfProduct)).getTitle();
    }

    public String getPriceOfProducts(int idOfProduct) {
        return new ProductComponent(products.get(idOfProduct)).getPrice();
    }


    public void addProductItemToCard(int idOfProduct) {
        new ProductComponent(products.get(idOfProduct)).addCard();
    }

    public void clickOnCardButton() {
        driver.findElement(By.xpath("//*[@class='shopping_cart_badge']")).click();
    }

    public void clickOnBurgerMenuBtn() {
        driver.findElement(burgerMenuBtn).click();
    }
    public void waitForElementIsInteractable() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(logoutBtn));
    }
    public void userLogout() {

        driver.findElement(logoutBtn).click();
    }

}
