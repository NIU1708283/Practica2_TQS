package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductNameSortingAZSteps {

    @When("I sort the products by {string}")
    public void sortProductsBy(String sortOption) {
        WebDriver driver = CommonSteps.getDriver();
        // Localizamos el elemento select del catálogo
        Select sortSelect = new Select(driver.findElement(By.className("product_sort_container")));
        
        // En Swag Labs, la opción "Name (A to Z)" tiene el valor interno "az"
        if (sortOption.equals("Name (A to Z)")) {
            sortSelect.selectByValue("az");
        }
    }

    @Then("the products should be sorted alphabetically from A to Z")
    public void verifyProductsSortedAZ() {
        WebDriver driver = CommonSteps.getDriver();
        // Obtenemos todos los nombres de productos mostrados
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        
        List<String> actualNames = new ArrayList<>();
        for (WebElement element : productElements) {
            actualNames.add(element.getText());
        }

        // Creamos una copia y la ordenamos alfabéticamente (A-Z) para comparar
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        Assert.assertEquals("El orden de los productos no es correcto (A-Z)", expectedNames, actualNames);
        
        // Cerramos el navegador al finalizar el escenario
        driver.quit();
    }
}