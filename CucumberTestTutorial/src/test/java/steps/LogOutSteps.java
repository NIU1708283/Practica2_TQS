package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class LogOutSteps {

    @When("I open the sidebar menu")
    public void openSidebar() {
        CommonSteps.getDriver().findElement(By.id("react-burger-menu-btn")).click();
    }

    @When("I select the {string} option")
    public void selectOption(String optionName) {
        WebDriverWait wait = new WebDriverWait(CommonSteps.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
    }

    @Then("I should be redirected to the login page")
    public void verifyLoginRedirect() {
        WebDriverWait wait = new WebDriverWait(CommonSteps.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        Assert.assertTrue(CommonSteps.getDriver().findElement(By.id("login-button")).isDisplayed());
    }

    @Then("I should not be able to return to the {string} page by navigating back")
    public void verifyBackNavigation(String pageTitle) {
        WebDriver driver = CommonSteps.getDriver();
        driver.navigate().back();
        boolean onLogin = driver.findElements(By.id("login-button")).size() > 0;
        Assert.assertTrue("El usuari ha pogut tornar enrere!", onLogin);
        driver.quit();
    }
}