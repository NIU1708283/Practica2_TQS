package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.List;

public class ProductVisualizationSteps {

    @Then("I should see that all products have a name, a price, and an image")
    public void verifyAllProductsHaveCompleteInfo() {
        WebDriver driver = CommonSteps.getDriver();
        
        // Obtenemos la lista de todos los contenedores de productos
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        
        // Verificamos que la lista no esté vacía
        Assert.assertFalse("No se han encontrado productos en la página", items.isEmpty());
        
        for (WebElement item : items) {
            // Verificamos el nombre
            String name = item.findElement(By.className("inventory_item_name")).getText();
            Assert.assertFalse("Se ha encontrado un producto sin nombre", name.isEmpty());
            
            // Verificamos el precio
            String price = item.findElement(By.className("inventory_item_price")).getText();
            Assert.assertFalse("El producto " + name + " no tiene precio", price.isEmpty());
            
            // Verificamos la imagen (que el tag exista y sea visible)
            WebElement image = item.findElement(By.tagName("img"));
            Assert.assertTrue("El producto " + name + " no tiene una imagen visible", image.isDisplayed());
        }
        
        // Cerramos el navegador al finalizar la validación del feature
        driver.quit();
    }
}