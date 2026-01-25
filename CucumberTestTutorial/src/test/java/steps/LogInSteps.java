package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class LogInSteps 
{
    WebDriver driver;

    @Before
    public void setup() {
        driver = CommonSteps.getDriver();
    }

    @Then("I should be redirected to the {string} page")
    public void iShouldBeRedirectedToThePage(String expectedPageTitle) {
        String actualTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(expectedPageTitle, actualTitle);
        driver.quit();
    }
}