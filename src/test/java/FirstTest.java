import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
    }

    @Test
    public void openBrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.get(Helper.CANVA);
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void clickLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.SAUCEDEMO);
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        By.id()
        WebElement loginBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.LOGINBTN)));
//        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(5000);
        driver.quit();
    }



    @Test
    public void findElement() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Duration duration = Duration.ofSeconds(5);
        driver.get(Helper.CANVA);
        WebDriverWait wait = new WebDriverWait(driver,duration);
//               By.xpath()
//        WebElement loginBtn = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CANVALOGINXPATH)));
//        By.cssSelector()
        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Helper.CANVACSSSELECTOR)));
        Thread.sleep(3000);
        loginBtn.click();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void loginUser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.SAUCEDEMO);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement loginField = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.LOGINID)));
        WebElement passwordField = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.PASSWORDID)));
        WebElement loginBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.LOGINBTN)));
        loginField.sendKeys(Helper.USERNAME);
        Thread.sleep(3000);
        passwordField.sendKeys(Helper.PASSWORD);
        Thread.sleep(3000);
        loginBtn.click();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void loginUsers() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        for (int i = 0; i < Helper.USERNAMEARR.length; i++) {
            System.out.println("i = " + i);
            driver.get(Helper.SAUCEDEMO);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            WebElement loginField = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.LOGINID)));
            WebElement passwordField = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.PASSWORDID)));
            WebElement loginBtn = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.LOGINBTN)));
            loginField.sendKeys(Helper.USERNAMEARR[i]);
            Thread.sleep(3000);
            passwordField.sendKeys(Helper.PASSWORD);
            Thread.sleep(3000);
            loginBtn.click();
            String newURL = driver.getCurrentUrl();
            Assert.assertEquals("https://www.saucedemo.com/inventory.html",newURL);
            Thread.sleep(3000);
        }
        driver.quit();
    }

    @Test
    public void assertTest(){
        // open browser
        WebDriver driver = new ChromeDriver();
        // goto address
        driver.get(Helper.SAUCEDEMO);
        // wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement usernameField = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.LOGINID)));
        WebElement passwordField = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.PASSWORDID)));
        WebElement loginBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.LOGINBTN)));
        usernameField.sendKeys(Helper.USERNAMEARR[1]);
//        usernameField.sendKeys(Helper.USERNAME);
        passwordField.sendKeys(Helper.PASSWORD);
        loginBtn.click();
        String newUrl = driver.getCurrentUrl();
//        if (newUrl == "https://www.saucedemo.com/inventory.html"){
//            System.out.println("works");
//        }else{
//            System.out.println("doesn't work");
//        }
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",newUrl);
        driver.quit();
    }

    @Test
    public void netflixText(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://help.netflix.com/legal/termsofuse");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement paragraph = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Helper.NETFLIXPARAGRAPHCSS)));
        String newText = paragraph.getText();
        Assert.assertEquals(Helper.NETFLIXPARAGRAPHTEXT,newText);
        driver.quit();
    }


    @Test
    public void netflixSignIn() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/il-en/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        WebElement signInBtn = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[1]/div/a")));
//        WebElement signInBtn = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign In")));
        WebElement signInBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("edia ")));
        signInBtn.click();
        Thread.sleep(5000);
        driver.quit();
    }


}
