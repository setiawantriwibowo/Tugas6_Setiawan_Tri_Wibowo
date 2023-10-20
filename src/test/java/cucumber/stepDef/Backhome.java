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

public class Backhome {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User sudah selesai cekout")
    public void homepage(){
        System.setProperty("Webdriver.chromedriver","C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(logo,"Swag Labs");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Setiawan");
        driver.findElement(By.id("last-name")).sendKeys("Wibowo");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

    }


    @When("user click backhome")
    public void userClickBackhome() {
        driver.findElement(By.id("back-to-products")).click();
    }

    @Then("redirect homepage")
    public void redirectHomePage(){
        WebElement home = driver.findElement((By.xpath("//span[@class='title']")));
        home.isDisplayed();
    }
}
