import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webpages.LoginPage;

public class TestLoginPage extends BaseStuff {

    LoginPage login = new LoginPage(driver);
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
    public void test1ValidUserAndPassword(){
        login.loginAccess(login.validUserName, login.validPassword);
        login.validatePage();
        scroll.executeScript("window.scrollBy(0,2000)","");
        Assert.assertEquals("Test did not pass", login.findBottomText(), login.bottomTextToFind);
    }

    @Test
    public void test2ValidUserWrongPassword(){
        login.loginAccess(login.validUserName, login.fakePassword());
        Assert.assertTrue("Test did not pass",login.badLogin().contains("do not match"));
    }

    @Test
    public void test3ValidPasswordWrongUser(){
        login.loginAccess(login.fakeUser(), login.validPassword);
        Assert.assertTrue("Test did not pass",login.badLogin().contains("do not match"));
    }

    @Test
    public void test4WrongUserWrongPassword(){
        login.loginAccess(login.fakeUser(), login.fakePassword());
        Assert.assertTrue("Test did not pass",login.badLogin().contains("do not match"));
    }

    @Test
    public void test5ValidUserNoPassword(){
        login.loginAccess(login.validUserName, "");
        Assert.assertTrue("Test did not pass",login.badLogin().contains("Password is required"));
    }

}
