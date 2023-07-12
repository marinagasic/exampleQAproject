package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class SocialLinks {

    public WebDriver driver;


    public By twitter = By.xpath("//*[text()=\"Twitter\"]");
    public By facebook= By.xpath("//*[text()=\"Facebook\"]");
    public By linkedIn = By.xpath("//*[text()=\"LinkedIn\"]");

    public SocialLinks(WebDriver driver){
        this.driver=driver;
    }

    public String openTwitterLink(){
        driver.findElement(twitter).click();
        // page opens in another tab
        Set<String> tabs = driver.getWindowHandles();

        Iterator<String> listOfTabs = tabs.iterator();

        String mainTab = listOfTabs.next();
        String twitterTab = listOfTabs.next();

        driver.switchTo().window(twitterTab);
        return mainTab;

    }

    public String openFacebookLink() {
        driver.findElement(facebook).click();
        Set<String> tabs = driver.getWindowHandles();

        Iterator<String> listOfTabs = tabs.iterator();

        String mainTab = listOfTabs.next();
        String facebookTab = listOfTabs.next();

        driver.switchTo().window(facebookTab);
        return mainTab;
    }

    public String openLinkedInLink(){
        driver.findElement(linkedIn).click();
        Set<String> tabs = driver.getWindowHandles();

        Iterator<String> listOfTabs = tabs.iterator();

        String mainTab = listOfTabs.next();
        String linkedInTab = listOfTabs.next();

        driver.switchTo().window(linkedInTab);
        return mainTab;

    }


    public boolean validateTwitter(String mainTab) throws InterruptedException {
        Thread.sleep(2000);
        boolean currentTabUrl = driver.getCurrentUrl().contains("twitter");
        driver.close();
        driver.switchTo().window(mainTab);
        return currentTabUrl;
    }

    public boolean validateFacebook(String mainTab) throws InterruptedException {
        Thread.sleep(2000);
        boolean currentTabUrl =  driver.getCurrentUrl().contains("facebook");
        driver.close();
        driver.switchTo().window(mainTab);
        return currentTabUrl;
    }

    public boolean validateLinkedIn(String mainTab) throws InterruptedException {
        Thread.sleep(2000);
        boolean currentTabUrl =  driver.getCurrentUrl().contains("linkedin");
        driver.close();
        driver.switchTo().window(mainTab);
        return currentTabUrl;

    }
}
