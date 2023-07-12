package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessShopping {

    public WebDriver driver;
    public By firstShoppingItem = By.xpath("//*[text()=\"Sauce Labs Backpack\"]");
    public By addToShoppingCart = By.xpath( "//*[text()=\"Add to cart\"]");
    public By proceedToCheckout = By.cssSelector("a[class=\"shopping_cart_link\"");
    public By proceedCheckout = By.id("checkout");

    public By fieldFirstName = By.xpath("//*[@placeholder=\"First Name\"]");
    public By fieldLastName = By.xpath("//*[@placeholder=\"Last Name\"]");
    public By fieldPostalCode = By.xpath("//*[@placeholder=\"Zip/Postal Code\"]");
    public String validFirstName = "Marina";
    public String validLastName = "Gasic";
    public String validPostalCode = "11030";

    public By proceedContinue = By.xpath("//*[@type=\"submit\"]");
    public By proceedFinish = By.xpath("//*[@data-test=\"finish\"]");
    public By shoppingResult = By.xpath("//*[text()=\"Thank you for your order!\"]");

    public By secondShoppingItem = By.xpath("//*[text()=\"Sauce Labs Onesie\"]");
    public By returnToProductsPage = By.xpath( "//*[@name=\"back-to-products\"]");

//    public By overviewCalculatedPrice = By.xpath("//*[@class=\"summary_info_label summary_total_label\"]");
    public By overviewCalculatedPrice = By.xpath("//*[@class=\"summary_subtotal_label\"]");
    public String expectedPrice = "Item total: $37.98";

    public SuccessShopping(WebDriver driver){
        this.driver=driver;

    }
    public void buyingOneItem(){
        driver.findElement(firstShoppingItem).click();
        driver.findElement(addToShoppingCart).click();
        driver.findElement(proceedToCheckout).click();
        driver.findElement(proceedCheckout).click();
        driver.findElement(fieldFirstName).sendKeys(validFirstName);
        driver.findElement(fieldLastName).sendKeys(validLastName);
        driver.findElement(fieldPostalCode).sendKeys(validPostalCode);
        driver.findElement(proceedContinue).click();
        driver.findElement(proceedFinish).click();
    }
    public String confirmationStatus(){
        return driver.findElement(shoppingResult).getText();
    }

    public void bonusBuyingItems(){
        driver.findElement(firstShoppingItem).click();
        driver.findElement(addToShoppingCart).click();
        driver.findElement(returnToProductsPage).click();
        driver.findElement(secondShoppingItem).click();
        driver.findElement(addToShoppingCart).click();
        driver.findElement(proceedToCheckout).click();
        driver.findElement(proceedCheckout).click();
        driver.findElement(fieldFirstName).sendKeys(validFirstName);
        driver.findElement(fieldLastName).sendKeys(validLastName);
        driver.findElement(fieldPostalCode).sendKeys(validPostalCode);
        driver.findElement(proceedContinue).click();
    }

    public boolean comparePrices(){
        return driver.findElement(overviewCalculatedPrice).getText().equals(expectedPrice);
    }

}
