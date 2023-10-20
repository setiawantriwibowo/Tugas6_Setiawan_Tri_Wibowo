package cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class cekout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given ("User sudah login saucedemo")
    public void login_saucedemo(){
        System.setProperty("Webdriver.chromedriver","C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String logo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(logo,"Swag Labs");

    }

    @When("user klik cart")
    public void userKlikCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("klick Cekout")
    public void klickCekout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("input firstname")
    public void inputFirstname() {
        driver.findElement(By.id("first-name")).sendKeys("Setiawan");
    }

    @And("input Lastname")
    public void inputLastname() {
        driver.findElement(By.id("last-name")).sendKeys("Wibowo");
    }

    @And("input postcode")
    public void inputPostcode() {
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("klik continue")
    public void klikContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("muncul cekout overview")
    public void munculCekoutOverview() {
        String result = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(result,"Checkout: Overview");
    }

    @Then("klik Finish")
    public void klikFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @When("user klik add to cart")
    public void userKlikAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    @Then("Cekout Finish")
    public void cekoutFinish() {
        String finish = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assert.assertEquals(finish,"Thank you for your order!");
        driver.quit();
    }

    @Then("muncul pesan error")
    public void munculPesanError() {
        String error = driver.findElement(By.xpath("//h3[normalize-space()='Error: First Name is required']")).getText();
        Assert.assertEquals(error,"Error: First Name is required");
        driver.quit();

    }

}
