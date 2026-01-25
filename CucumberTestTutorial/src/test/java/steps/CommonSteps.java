package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class CommonSteps {
	private static WebDriver driver;

    @Given("I am on the Swag Labs login page")
    public void iAmOnTheSwagLabsLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with user {string} and password {string}")
    public void performLogin(String user, String pass) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see an error message containing {string}")
    public void verifyErrorMessage(String expectedMsg) {
        String actualMsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertTrue("L'error esperat no coincideix!", actualMsg.contains(expectedMsg));
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
