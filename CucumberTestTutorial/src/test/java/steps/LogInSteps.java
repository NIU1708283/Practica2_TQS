package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LogInSteps {

    @Then("I should be redirected to the {string} page")
    public void iShouldBeRedirectedToThePage(String expectedPageTitle) {
        String actualTitle = CommonSteps.getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(expectedPageTitle, actualTitle);
        CommonSteps.getDriver().quit();
    }
}