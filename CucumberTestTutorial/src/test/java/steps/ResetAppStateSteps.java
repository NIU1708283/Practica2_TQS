package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.junit.Assert;

public class ResetAppStateSteps {

    @Then("the cart counter should not be displayed")
    public void verifyCartIsEmpty() {
        int badgeSize = CommonSteps.getDriver().findElements(By.className("shopping_cart_badge")).size();
        Assert.assertEquals("El estado de la aplicación no se ha reseteado (el carrito no está vacío)", 0, badgeSize);
        
        CommonSteps.getDriver().quit();
    }
}