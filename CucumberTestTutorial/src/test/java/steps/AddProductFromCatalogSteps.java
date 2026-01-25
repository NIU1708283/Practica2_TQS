package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class AddProductFromCatalogSteps {

    @When("I add the product {string} to the cart")
    public void addProductToCart(String productName) {
        WebDriver driver = CommonSteps.getDriver();
        // Localizamos el botón "Add to cart" dentro del contenedor del producto especificado
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item_description']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    @Then("the cart counter should show {string}")
    public void verifyCartCounter(String expectedCount) {
        WebDriver driver = CommonSteps.getDriver();
        // El contador aparece en un badge sobre el icono del carrito
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String actualCount = cartBadge.getText();
        
        Assert.assertEquals("El contador del carrito no coincide", expectedCount, actualCount);
        
        // Cerramos el navegador al finalizar la verificación del escenario
        driver.quit();
    }
}