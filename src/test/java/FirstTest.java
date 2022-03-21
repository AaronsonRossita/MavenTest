import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void openBrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.canva.com/");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void clickLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        loginBtn.click();
    }


}
