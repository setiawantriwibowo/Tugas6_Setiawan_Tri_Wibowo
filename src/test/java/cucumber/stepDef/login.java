package cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given ("halaman login saucedemo")
    public void halaman_login_saucedemo(){
        System.setProperty("Webdriver.chromedriver","C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String loginPage = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPage,"Swag Labs");
    }
    @When("input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user redirect to swag labs page")
    public void userRedirectToSwagLabsPage() {
        String logo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(logo,"Swag Labs");
        driver.quit();
    }

    @And("input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauceee");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String error = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText();
        Assert.assertEquals(error,"Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
}
