package browserfactory;
/**1. Create the package ‘browserfactory’ and create the
 class with the name ‘BaseTest’ inside the
 ‘browserfactory’ package. And write the browser setup
 code inside the class ‘Base Test’.
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    //public static String baseUrl = "";


    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        //Launch URL
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //Implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        driver.quit();
    }
}
