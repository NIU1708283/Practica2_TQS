package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;

public class AddProductFromDetailsSteps {

    @When("I click the {string} button on the details page")
    public void addProductFromDetails(String buttonText) throws InterruptedException {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='add-to-cart']"))).click();
        Thread.sleep(1000);
    }
}