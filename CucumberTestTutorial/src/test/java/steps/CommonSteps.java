package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

public class CommonSteps {
    private static WebDriver driver;

    @Given("I am on the Swag Labs login page")
    public void iAmOnTheSwagLabsLoginPage() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        iAmOnTheSwagLabsLoginPage();
    }

    @When("I login with user {string} and password {string}")
    public void performLogin(String user, String pass) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
    }
    
    @When("I sort the products by {string}")
    public void sortProductsBy(String sortOption) {
        org.openqa.selenium.support.ui.Select sortSelect = 
            new org.openqa.selenium.support.ui.Select(driver.findElement(By.className("product_sort_container")));
        
        if (sortOption.equals("Name (A to Z)")) sortSelect.selectByValue("az");
        else if (sortOption.equals("Name (Z to A)")) sortSelect.selectByValue("za");
        else if (sortOption.equals("Price (low to high)")) sortSelect.selectByValue("lohi");
        else if (sortOption.equals("Price (high to low)")) sortSelect.selectByValue("hilo");
    }
    
    @Then("the cart counter should show {string}")
    public void verifyCartCounter(String expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Esperar a que el elemento sea visible y tenga el texto esperado
        org.openqa.selenium.WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='shopping-cart-badge']")));
        // Esperar a que tenga el texto correcto
        wait.until(ExpectedConditions.textToBePresentInElement(cartBadge, expectedCount));
        Assert.assertEquals("El contador no es correcto", expectedCount, cartBadge.getText());
    }
    

    @Then("I should see an error message containing {string}")
    public void verifyErrorMessage(String expectedMsg) {
        try {
            String actualMsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertTrue(actualMsg.contains(expectedMsg));
        } catch (Exception e) {
            // Intenta buscar cualquier elemento con clase error
            String actualMsg = driver.findElement(By.xpath("//*[contains(@class, 'error')]")).getText();
            Assert.assertTrue("El mensaje de error debería contener: " + expectedMsg, actualMsg.contains(expectedMsg));
        }
    }
    
    @When("I click on the {string} button")
    public void clickButtonById(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String id = "";
        if (buttonName.equalsIgnoreCase("Checkout")) id = "checkout";
        else if (buttonName.equalsIgnoreCase("Continue")) id = "continue";
        else if (buttonName.equalsIgnoreCase("Finish")) id = "finish";
        
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
        } catch (Exception e) {
            // Intenta por XPath buscando button por texto (case-insensitive)
            String xpathLower = "//button[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + buttonName.toLowerCase() + "')]";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLower))).click();
        }
    }

    @When("I go to the cart")
    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
    }
    
    @When("I open the sidebar menu")
    public void openSidebar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();
    }

    @When("I select the {string} option")
    public void selectSidebarOption(String optionName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        String id = "";
        if (optionName.equalsIgnoreCase("Logout")) id = "logout_sidebar_link";
        else if (optionName.equalsIgnoreCase("Reset App State")) id = "reset_sidebar_link";
        
        // Esperar a que la opción esté visible y sea clickeable
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }
    
    @Then("the cart counter should not be displayed")
    public void verifyCartCounterNotDisplayed() {
        int badgeCount = driver.findElements(By.className("shopping_cart_badge")).size();
        Assert.assertEquals("El contador del carrito no debería ser visible", 0, badgeCount);
    }

    public static WebDriver getDriver() {
        return driver;
    }
    
    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}