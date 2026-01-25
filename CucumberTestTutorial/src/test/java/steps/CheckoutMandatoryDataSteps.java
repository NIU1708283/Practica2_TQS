package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutMandatoryDataSteps {

    @When("I enter the first name {string}, last name {string} and zip code {string}")
    public void fillCheckoutForm(String firstName, String lastName, String zipCode) {
        WebDriver driver = CommonSteps.getDriver();
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
    }
}