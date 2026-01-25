package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class LogOutSteps {

    @Then("I should be redirected to the login page")
    public void verifyLoginRedirect() {
        WebDriverWait wait = new WebDriverWait(CommonSteps.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        Assert.assertTrue(CommonSteps.getDriver().findElement(By.id("login-button")).isDisplayed());
    }

    @Then("I should not be able to return to the {string} page by navigating back")
    public void verifyBackNavigation(String pageTitle) {
        CommonSteps.getDriver().navigate().back();
        boolean onLogin = CommonSteps.getDriver().findElements(By.id("login-button")).size() > 0;
        Assert.assertTrue("¡El usuario ha podido volver atrás!", onLogin);
        CommonSteps.getDriver().quit();
    }
    
}