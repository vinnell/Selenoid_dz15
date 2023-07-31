package org.example.pages;

import org.example.pages.components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    private By addButton = By.xpath("//*[text()='Add to cart']");
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

    public void clickOnAddButton() {
        driver.findElement(addButton).click();
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

    public void userLogout() {
        driver.findElement(logoutBtn).click();
    }

}
