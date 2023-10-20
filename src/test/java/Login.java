import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Login {
    @Test
    public void open_browser(){

        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chromedriver","C:\\Windows\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.close();

    }
    @Test
    public void valid_login(){

        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chromedriver","C:\\Windows\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(logo,"Swag Labs");
        driver.close();

    }
    @Test
    public void invalid_login(){

        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chromedriver","C:\\Windows\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauceee");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText();
        Assert.assertEquals(error,"Epic sadface: Username and password do not match any user in this service");
        driver.close();

    }
}
