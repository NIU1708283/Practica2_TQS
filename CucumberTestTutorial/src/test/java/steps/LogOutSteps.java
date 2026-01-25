package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class LogOutSteps {
    // Usamos el driver ya iniciado en los pasos anteriores
    WebDriver driver = LogInSteps.driver; 

    @When("I open the sidebar menu")
    public void openSidebar() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @When("I select the {string} option")
    public void selectOption(String optionName) {
        // Usamos una espera explícita porque el menú tiene una animación
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
    }

    @Then("I should be redirected to the login page")
    public void verifyLoginRedirect() {
        boolean isLoginButtonPresent = driver.findElement(By.id("login-button")).isDisplayed();
        Assert.assertTrue("No se redirigió a la página de login", isLoginButtonPresent);
    }

    @Then("I should not be able to return to the {string} page by navigating back")
    public void verifyBackNavigation(String pageTitle) {
        // Simulamos el botón "Atrás" del navegador
        driver.navigate().back();
        
        // Verificamos que seguimos en la página de login (o que el botón de login sigue ahí)
        boolean isStillOnLoginPage = driver.findElements(By.id("login-button")).size() > 0;
        Assert.assertTrue("El usuario pudo volver atrás a una zona protegida", isStillOnLoginPage);
        
        driver.quit();
    }
}