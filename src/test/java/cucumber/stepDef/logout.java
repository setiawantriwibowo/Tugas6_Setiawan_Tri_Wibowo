package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User sudah dihomepage")
    public void homepage(){
        System.setProperty("Webdriver.chromedriver","C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(logo,"Swag Labs");

    }

    @When("user click burger menu")
    public void userClickBurgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User klik logout button")
    public void userKlikLogoutButton() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("redirect loginpage")
    public void redirectLoginpage() {
        WebElement login = driver.findElement(By.id("login-button"));
        login.isDisplayed();

    }
}
