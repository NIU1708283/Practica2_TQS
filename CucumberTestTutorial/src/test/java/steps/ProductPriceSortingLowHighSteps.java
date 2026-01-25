package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPriceSortingLowHighSteps {

    @Then("the products should be sorted by price from low to high")
    public void verifyProductsSortedLowHigh() {
        WebDriver driver = CommonSteps.getDriver();
        
        // Extreiem els elements de preu
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualPrices = new ArrayList<>();
        
        for (WebElement element : priceElements) {
            // Eliminem el símbol "$" i convertim el text a Double per a poder comparar-los numèricament
            String priceText = element.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
        }

        // Creem una llista amb l'ordre esperat (ordenat de menor a major)
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals("L'ordre dels preus no és correcte (Bajo a Alto)", expectedPrices, actualPrices);
        
        driver.quit();
    }
}