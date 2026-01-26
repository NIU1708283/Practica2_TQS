package steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class ProductVisualizationSteps {

    @Then("I should see that all products have a name, a price, and an image")
    public void verifyAllProductsHaveCompleteInfo() {
        WebDriver driver = CommonSteps.getDriver();
        
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        
        Assert.assertFalse("No se han encontrado productos en la página", items.isEmpty());
        
        for (WebElement item : items) {
            String name = item.findElement(By.className("inventory_item_name")).getText();
            Assert.assertFalse("Se ha encontrado un producto sin nombre", name.isEmpty());
            
            String price = item.findElement(By.className("inventory_item_price")).getText();
            Assert.assertFalse("El producto " + name + " no tiene precio", price.isEmpty());
            
            WebElement image = item.findElement(By.tagName("img"));
            Assert.assertTrue("El producto " + name + " no tiene una imagen visible", image.isDisplayed());
        }
    }
}