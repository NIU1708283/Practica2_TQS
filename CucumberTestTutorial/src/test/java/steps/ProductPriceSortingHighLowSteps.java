package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPriceSortingHighLowSteps {

    @Then("the products should be sorted by price from high to low")
    public void verifyProductsSortedHighLow() {
        WebDriver driver = CommonSteps.getDriver();
        
        // Extreiem els preus de la interfície
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualPrices = new ArrayList<>();
        
        for (WebElement element : priceElements) {
            // Netegem el símbol "$" i convertim a numèric
            String priceText = element.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
        }

        // Calculem l'ordre esperat: Ordenem de menor a major i invertim (Alt a Baix)
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);
        Collections.reverse(expectedPrices);

        Assert.assertEquals("L'ordre dels preus no és correcte (Alt a Baix)", expectedPrices, actualPrices);
        
        // Tanquem el navegador
        driver.quit();
    }
}