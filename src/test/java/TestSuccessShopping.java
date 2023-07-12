import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webpages.LoginPage;
import webpages.SuccessShopping;

public class TestSuccessShopping extends BaseStuff{

    LoginPage login = new LoginPage(driver);
    public String urlHomePage ="https://www.saucedemo.com/";
    SuccessShopping purchasing = new SuccessShopping(driver);

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
    public void test1SuccessfulShopping(){
        login.loginAccess(login.validUserName, login.validPassword);
        purchasing.buyingOneItem();
        Assert.assertTrue("Test did not pass",purchasing.confirmationStatus().contains("Thank you"));
    }
    
    @Test
    public void test2Bonus(){
        login.loginAccess(login.validUserName, login.validPassword);
        purchasing.bonusBuyingItems();
        Assert.assertTrue("Test did not pass",purchasing.comparePrices());
    }
}
