package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.junit.Assert;

public class CheckoutSuccessSteps {

    @Then("I should see the confirmation message {string}")
    public void verifyConfirmationMessage(String expectedMessage) {
        String actualMessage = CommonSteps.getDriver().findElement(By.className("complete-header")).getText();
        Assert.assertEquals("El mensaje de confirmación no es el esperado", expectedMessage, actualMessage);
        
        // Cerramos el navegador al finalizar el flujo completo
        CommonSteps.getDriver().quit();
    }
}