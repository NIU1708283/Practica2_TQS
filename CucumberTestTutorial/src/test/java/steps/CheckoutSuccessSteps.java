package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import java.time.Duration;

public class CheckoutSuccessSteps {

    @Then("I should see the confirmation message {string}")
    public void verifyConfirmationMessage(String expectedMessage) {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Esperar a que cargue el mensaje de confirmación
        WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
        String actualMessage = confirmationElement.getText().toUpperCase();
        
        Assert.assertEquals("El mensaje de confirmación no es el esperado", expectedMessage.toUpperCase(), actualMessage);
    }
}