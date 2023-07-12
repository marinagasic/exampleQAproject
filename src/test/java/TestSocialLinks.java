import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webpages.LoginPage;
import webpages.SocialLinks;

public class TestSocialLinks extends BaseStuff{



    LoginPage login = new LoginPage(driver);
    SocialLinks social = new SocialLinks(driver);
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
    public void test1Twitter() throws InterruptedException {
        login.loginAccess(login.validUserName,login.validPassword);
        scroll.executeScript("window.scrollBy(0,2000)","");
        String previousTab = social.openTwitterLink();
        Assert.assertTrue("Test did not past", social.validateTwitter(previousTab));

    }

    @Test
    public void test2Facebook() throws InterruptedException {
        login.loginAccess(login.validUserName,login.validPassword);
        scroll.executeScript("window.scrollBy(0,2000)","");
        String previousTab = social.openFacebookLink();
        Assert.assertTrue("Test did not past", social.validateFacebook(previousTab));
    }

    @Test
    public void test3LinkedIn() throws InterruptedException {
        login.loginAccess(login.validUserName,login.validPassword);
        scroll.executeScript("window.scrollBy(0,2000)","");
        String previousTab = social.openLinkedInLink();
        Assert.assertTrue("Test did not past", social.validateLinkedIn(previousTab));
    }
}
