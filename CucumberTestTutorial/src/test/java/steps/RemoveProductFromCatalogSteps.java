package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;

public class RemoveProductFromCatalogSteps {

    @When("I remove the product {string} from the inventory")
    public void removeProductFromInventory(String productName) {
        WebDriver driver = CommonSteps.getDriver();
        String xpath = "//div[contains(text(), '" + productName + "')]/ancestor::div[@class='inventory_item_description']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

}