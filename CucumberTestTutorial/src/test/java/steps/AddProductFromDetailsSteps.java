package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductFromDetailsSteps {

    @When("I click the {string} button on the details page")
    public void addProductFromDetails(String buttonText) {
        WebDriver driver = CommonSteps.getDriver();
        // En la página de detalles, el botón suele tener el texto "Add to cart"
        // Usamos un XPath que busque el botón por su texto para que sea genérico
        String xpath = "//button[contains(text(), '" + buttonText + "')]";
        driver.findElement(By.xpath(xpath)).click();
    }
}