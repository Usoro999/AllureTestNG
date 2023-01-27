package Config;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static WebDriver driver;


    @BeforeMethod
    public static void createDriver(){
        driver = DriverConfig.createDriver(BROWSERS.CHROMEINCOGNITO);
    }

    @BeforeMethod
    public static void closeDriver(){
        if(driver != null){

            driver.quit();
        }
    }
}

