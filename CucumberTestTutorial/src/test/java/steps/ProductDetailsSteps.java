package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ProductDetailsSteps {

    @When("I click on the name of the product {string}")
    public void clickOnProductName(String productName) {
        WebDriver driver = CommonSteps.getDriver();
        // Buscamos el link del nombre que coincida exactamente con el texto
        WebElement productLink = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
        productLink.click();
    }

    @When("I click on the image of the product {string}")
    public void clickOnProductImage(String productName) {
        WebDriver driver = CommonSteps.getDriver();
        // Localizamos el contenedor del producto por su nombre y luego buscamos su imagen asociada
        String xpath = "//div[@class='inventory_item_description' and .//div[text()='" + productName + "']]/preceding-sibling::div[@class='inventory_item_img']//img";
        driver.findElement(By.xpath(xpath)).click();
    }

    @Then("I should see the details page for {string}")
    public void verifyProductDetailsPage(String expectedName) {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Esperamos a que cargue el nombre en la página de detalles
        WebElement detailsName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_name")));
        
        Assert.assertEquals("El nombre del producto en el detalle no es el esperado", expectedName, detailsName.getText());
        
        // Importante: Cerramos el driver para limpiar la sesión del test
        driver.quit();
    }
}