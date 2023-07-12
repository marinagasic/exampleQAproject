import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseStuff {
   public static WebDriver driver;
   JavascriptExecutor scroll=(JavascriptExecutor) driver;

   @BeforeClass
   public static void beforeClass() throws Exception{
      WebDriverManager.firefoxdriver().setup();
      driver=new FirefoxDriver();
      driver.manage().window().maximize();
   }
   @AfterClass
   public static void afterClas() throws Exception{
      driver.quit();
   }









}
