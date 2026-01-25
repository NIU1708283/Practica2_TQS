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
        String xpath = "//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item_description']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

}