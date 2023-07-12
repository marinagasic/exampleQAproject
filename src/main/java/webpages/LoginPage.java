 package webpages;

 import com.github.javafaker.Faker;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;

 public class LoginPage {
    public WebDriver driver;
    public By user = By.xpath("//input[@placeholder=\"Username\"]");
    public By password = By.name("password");
    public By loginButton = By.xpath("//*[@data-test=\"login-button\"]");
    public String validUserName="standard_user";
    public String validPassword ="secret_sauce";

    public String expectedUrl = "https://www.saucedemo.com/inventory.html";
    public By logo= By.xpath("//*[@class=\"app_logo\"][text()=\"Swag Labs\"]");

    public By bottomElement = By.xpath("//*[@class=\"footer_copy\"]");
    public String bottomTextToFind = "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";

    Faker faker=new Faker();
    public By badLoginText=By.cssSelector("h3[data-test=\"error\"");

//  constructor
    public LoginPage (WebDriver driver){
        this.driver=driver;
    }


    public void loginAccess(String entryUserName, String entryPassword){
        driver.findElement(user).sendKeys(entryUserName);
        driver.findElement(password).sendKeys(entryPassword);
        driver.findElement(loginButton).click();
    }
    public void validatePage(){
        testLoginPageUrl();
        testLogoExistence();
    }
    public boolean testLoginPageUrl(){
        return driver.getCurrentUrl().equals(expectedUrl);

    }
    public boolean testLogoExistence(){
        return driver.findElement(logo).isDisplayed();
    }
    public String findBottomText(){
        return driver.findElement(bottomElement).getText();
    }
    public String fakePassword(){
        return faker.toString();
    }
    public String badLogin(){
        return driver.findElement(badLoginText).getText();

    }
    public String fakeUser(){
        return faker.name().username();
    }

























}
