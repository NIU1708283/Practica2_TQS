package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;

public class CheckoutMandatoryDataSteps {

    @When("I enter the first name {string}, last name {string} and zip code {string}")
    public void fillCheckoutForm(String firstName, String lastName, String zipCode) {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));
        
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        
        firstNameField.clear();
        lastNameField.clear();
        postalCodeField.clear();
        
        if (!firstName.isEmpty()) {
            firstNameField.sendKeys(firstName);
        }
        if (!lastName.isEmpty()) {
            lastNameField.sendKeys(lastName);
        }
        if (!zipCode.isEmpty()) {
            postalCodeField.sendKeys(zipCode);
        }
    }
}