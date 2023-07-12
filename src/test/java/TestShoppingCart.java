import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import webpages.LoginPage;
import webpages.ShoppingCart;

public class TestShoppingCart extends BaseStuff {

    LoginPage login=new LoginPage(driver);
    ShoppingCart cart = new ShoppingCart(driver);

    public String urlHomePage ="https://www.saucedemo.com/";

    @Before
    public void openHomePage(){
        driver.get(urlHomePage);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().back();
    }

    @Test
    public void test1AddTwoProductsToShoppingCart(){
        login.loginAccess(login.validUserName,login.validPassword);
        cart.addItemsToCart();
        cart.validateShoppingCart();
    }

    @Test
    public void test2AddTwoRemoveOneProductsToShoppingCart(){
        login.loginAccess(login.validUserName,login.validPassword);
        cart.addItemsToCart();
        cart.removeFrstItem();
        cart.validateCartWithOneItem();
    }



















}
