package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductNameSortingZASteps {

    @Then("the products should be sorted alphabetically from Z to A")
    public void verifyProductsSortedZA() {
        WebDriver driver = CommonSteps.getDriver();
        
        // Extraemos los nombres de los productos de la web
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        List<String> actualNames = new ArrayList<>();
        for (WebElement element : productElements) {
            actualNames.add(element.getText());
        }

        // Creamos la lista esperada: Ordenamos A-Z y luego invertimos
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);
        Collections.reverse(expectedNames);

        Assert.assertEquals("El orden de los productos no es correcto (Z-A)", expectedNames, actualNames);
        
        driver.quit();
    }
}