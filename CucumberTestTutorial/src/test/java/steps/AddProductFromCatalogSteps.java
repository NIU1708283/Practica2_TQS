package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;

public class AddProductFromCatalogSteps {
    
    private int productIndex = 0;

    @When("I add the product {string} to the cart")
    public void addProductToCart(String productName) throws InterruptedException {
        WebDriver driver = CommonSteps.getDriver();
        
        addProductByIndex(driver, productIndex);
        
        productIndex++;
        
        Thread.sleep(1000);
    }
    
    private void addProductByIndex(WebDriver driver, int index) {
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("button[data-test^='add-to-cart-']"));
        
        if (index < addToCartButtons.size()) {
            addToCartButtons.get(index).click();
        } else {
            throw new RuntimeException("Producto en índice " + index + " no encontrado. Solo hay " + addToCartButtons.size() + " productos disponibles.");
        }
    }

}