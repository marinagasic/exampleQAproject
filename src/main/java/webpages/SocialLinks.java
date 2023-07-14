package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SocialLinks {

    public WebDriver driver;

    public By twitter = By.xpath("//*[text()=\"Twitter\"]");
    public By facebook = By.xpath("//*[text()=\"Facebook\"]");
    public By linkedIn = By.xpath("//*[text()=\"LinkedIn\"]");

    public SocialLinks(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSocialNetwork(String socialNetworkName) {
        if (socialNetworkName.equals("twitter")) {
            driver.findElement(twitter).click();
        } else if (socialNetworkName.equals("facebook")) {
            driver.findElement(facebook).click();
        } else if (socialNetworkName.equals("linkedin")) {
            driver.findElement(linkedIn).click();
        } else {
            System.out.println("Unknown social network name");
        }
    }

    public Set<String> listOfTabs() {
        return driver.getWindowHandles();
    }

    public void switchToTab(String desiredTab) {
        driver.switchTo().window(desiredTab);
    }

    public void closeCurrentTab() {
        driver.close();
    }

    public boolean validateByUrlContains(String socialNetworkName) throws InterruptedException {
        Thread.sleep(2000);
        return driver.getCurrentUrl().contains(socialNetworkName);
    }
}