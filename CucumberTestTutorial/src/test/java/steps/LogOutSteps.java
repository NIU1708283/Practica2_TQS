package steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;

public class LogOutSteps {

    @Then("I should be redirected to the login page")
    public void verifyLoginRedirect() {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        } catch (Exception e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'LOGIN') or contains(@id, 'login')]")));
        }
        
        boolean isLoginPageDisplayed = driver.findElements(By.id("login-button")).size() > 0 || 
                                      driver.findElements(By.xpath("//button[contains(text(), 'LOGIN')]")).size() > 0;
        Assert.assertTrue("No se encontró el botón de login", isLoginPageDisplayed);
    }

    @Then("I should not be able to return to the {string} page by navigating back")
    public void verifyBackNavigation(String pageTitle) {
        WebDriver driver = CommonSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.navigate().back();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        boolean onLogin = driver.findElements(By.id("login-button")).size() > 0;
        Assert.assertTrue("¡El usuario ha podido volver atrás!", onLogin);
    }
    
}