package org.example.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent {
    private WebElement parentElement;
    private WebElement titleOfProduct;
    private WebElement priceOfProduct;

    public ProductComponent(WebElement parentElement) {
        this.parentElement = parentElement;
    }
    public String getTitle() {
        return parentElement.findElement(By.cssSelector(".inventory_item_name")).getText();

    }
        public String getPrice(){
            return parentElement.findElement(By.cssSelector(".inventory_item_price")).getText();
    }
    public void addCard(){
         parentElement.findElement(By.xpath("//*[text()='Add to cart']")).click();
    }

}
