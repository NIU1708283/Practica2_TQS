package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.junit.Assert;

public class AutenticationErrorManagementSteps {
    @Then("I should see an error message containing {string}")
    public void verifyErrorMessage(String expectedMsg) {
        String actualMsg = CommonSteps.getDriver().findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertTrue("L'error esperat no coincideix!", actualMsg.contains(expectedMsg));
        CommonSteps.getDriver().quit();
    }
}