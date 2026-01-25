package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class RemoveProductFromCatalogSteps {

    @When("I remove the product {string} from the inventory")
    public void removeProductFromInventory(String productName) {
        WebDriver driver = CommonSteps.getDriver();
        // En Swag Labs, el botón de "Remove" aparece en el mismo lugar que "Add to cart" 
        // una vez que el producto ha sido añadido.
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item_description']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    @Then("the cart counter should not be displayed")
    public void verifyCartCounterNotDisplayed() {
        WebDriver driver = CommonSteps.getDriver();
        // En Swag Labs, cuando el carrito está vacío, el elemento 'shopping_cart_badge' desaparece del DOM.
        int badgeCount = driver.findElements(By.className("shopping_cart_badge")).size();
        
        Assert.assertEquals("El contador del carrito sigue visible cuando debería estar vacío", 0, badgeCount);
        
        driver.quit();
    }
}