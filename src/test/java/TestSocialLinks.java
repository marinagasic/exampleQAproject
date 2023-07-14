import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webpages.LoginPage;
import webpages.SocialLinks;

import java.util.Iterator;
import java.util.Set;

public class TestSocialLinks extends BaseStuff{

    LoginPage login = new LoginPage(driver);
    SocialLinks social = new SocialLinks(driver);
    public String urlHomePage ="https://www.saucedemo.com/";


    public void testStepsForSocialNetworkLink(String socialNetworkName) throws InterruptedException{
        login.loginAccess(login.validUserName, login.validPassword);
        scroll.executeScript("window.scrollBy(0,2000)", "");
        social.selectSocialNetwork(socialNetworkName);

        Set<String> openTabs = social.listOfTabs();

        Iterator<String> tabs = openTabs.iterator();
        String mainTab = tabs.next();
        String socialNetworkTab = tabs.next();

        social.switchToTab(socialNetworkTab);
        Assert.assertTrue("Test did not pass", social.validateByUrlContains(socialNetworkName));
        social.closeCurrentTab();
        social.switchToTab(mainTab);
    }

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
    public void test1Twitter() throws InterruptedException{
        testStepsForSocialNetworkLink("twitter");
    }

    @Test
    public void test2Facebook() throws InterruptedException{
        testStepsForSocialNetworkLink("facebook");
    }

    @Test
    public void test3LinkedIn() throws InterruptedException{
        testStepsForSocialNetworkLink("linkedin");
    }
}
