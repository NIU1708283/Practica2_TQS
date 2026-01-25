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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Buscamos el link del nombre que coincida con el texto usando contains() para mayor robustez
        String xpath = "//a[contains(., '" + productName + "')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    @When("I click on the image of the product {string}")
    public void clickOnProductImage(String productName) {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Localizamos el contenedor del producto por su nombre y luego buscamos su imagen asociada
        String xpath = "//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item']//img";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    @Then("I should see the details page for {string}")
    public void verifyProductDetailsPage(String expectedName) {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Esperamos a que cargue el nombre en la página de detalles
        WebElement detailsName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_name")));
        
        Assert.assertEquals("El nombre del producto en el detalle no es el esperado", expectedName, detailsName.getText());
    }
}