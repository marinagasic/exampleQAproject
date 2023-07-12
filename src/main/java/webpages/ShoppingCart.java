package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart {
    public WebDriver driver;
    public By firstShoppingItem = By.xpath("//*[text()=\"Sauce Labs Fleece Jacket\"]");
    public By secondShoppingItem = By.xpath("//*[text()=\"Sauce Labs Bolt T-Shirt\"]");
    public By addToShoppingCart = By.xpath( "//*[text()=\"Add to cart\"]");
    public By returnToProductsPage = By.xpath( "//*[@name=\"back-to-products\"]");
    public By proceedToCheckout = By.cssSelector("a[class=\"shopping_cart_link\"");

    public By cartItemsList= By.cssSelector("div[class=\"cart_list\"]");

    public By firstItemRemoveButton = By.xpath("//button[text()=\"Remove\"]");
    public By shoppingCartBadge = By.cssSelector("span[class=\"shopping_cart_badge\"");




    public ShoppingCart(WebDriver driver){
        this.driver=driver;
    }

    public void addItemsToCart(){
        driver.findElement(firstShoppingItem).click();
        driver.findElement(addToShoppingCart).click();
        driver.findElement(returnToProductsPage).click();
        driver.findElement(secondShoppingItem).click();
        driver.findElement(addToShoppingCart).click();
        driver.findElement(proceedToCheckout).click();
    }
    public boolean validateShoppingCart(){
        return driver.findElement(cartItemsList).isDisplayed();
    }
    public void removeFrstItem(){
        driver.findElement(proceedToCheckout).click();
//        driver.findElement(firstItemRemoveButton).click();
        driver.findElements(firstItemRemoveButton).get(0).click();
    }
    public boolean validateCartWithOneItem(){
        return driver.findElement(shoppingCartBadge).getText().equals("1");
    }














}
