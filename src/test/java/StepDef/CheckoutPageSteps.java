package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckoutPageSteps {
    WebDriver driver;
    @Given("User opened google chrome browser")
    public void userOpenedGoogleChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/rakagustipradana/automation/mifxProject-main/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @When("User opened luna website to sign in")
    public void userOpenedLunaWebsiteToSignIn() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");
        Thread.sleep(1000);
    }

    @And("User click on sign in button")
    public void userClickOnSignInButton() {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
    }

    @And("User fill out email and password")
    public void userFillOutEmailAndPassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("email")).sendKeys("rakatel.rgp@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Gusti123");
        driver.findElement(By.id("send2")).click();
    }

    @And("User go to men catalogue and select product")
    public void userGoToMenCatalogueAndSelectProduct() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a")).click();
        driver.findElement(By.id("option-label-size-143-item-166")).click();
        driver.findElement(By.id("option-label-color-93-item-49")).click();
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("product-addtocart-button")).click();
        driver.navigate().to("https://magento.softwaretestingboard.com/men/bottoms-men/pants-men.html");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a")).click();
        driver.findElement(By.id("option-label-size-143-item-175")).click();
        driver.findElement(By.id("option-label-color-93-item-49")).click();
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("product-addtocart-button")).click();
        driver.navigate().refresh();
    }

    @And("User go to order summary")
    public void userGoToOrderSummary() {
        driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#shipping");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("User select payment method")
    public void userSelectPaymentMethod() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#payment");
    }

    @And("User finish to payment")
    public void userFinishToPayment() {
        driver.navigate().to("https://magento.softwaretestingboard.com/checkout/onepage/success/");
        driver.close();
        driver.quit();
    }
}
