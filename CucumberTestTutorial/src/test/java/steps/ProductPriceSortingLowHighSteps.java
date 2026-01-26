package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class ProductPriceSortingLowHighSteps {

    @Then("the products should be sorted by price from low to high")
    public void verifyProductsSortedLowHigh() {
        WebDriver driver = CommonSteps.getDriver();
        
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualPrices = new ArrayList<>();
        
        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals("L'ordre dels preus no és correcte (Bajo a Alto)", expectedPrices, actualPrices);
    }
}