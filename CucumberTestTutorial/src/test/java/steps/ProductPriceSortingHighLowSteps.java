package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class ProductPriceSortingHighLowSteps {

    @Then("the products should be sorted by price from high to low")
    public void verifyProductsSortedHighLow() {
        WebDriver driver = CommonSteps.getDriver();
        
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualPrices = new ArrayList<>();
        
        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);
        Collections.reverse(expectedPrices);

        Assert.assertEquals("L'ordre dels preus no és correcte (Alt a Baix)", expectedPrices, actualPrices);
    }
}