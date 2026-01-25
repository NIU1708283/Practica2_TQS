package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

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
        org.openqa.selenium.WebElement cartBadge = getDriver().findElement(By.className("shopping_cart_badge"));
        org.junit.Assert.assertEquals("El contador no es correcto", expectedCount, cartBadge.getText());
        getDriver().quit();
    }
    

    @Then("I should see an error message containing {string}")
    public void verifyErrorMessage(String expectedMsg) {
        String actualMsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        org.junit.Assert.assertTrue(actualMsg.contains(expectedMsg));
        driver.quit();
    }
    
    @When("I click on the {string} button")
    public void clickButtonById(String buttonName) {
        String id = "";
        if (buttonName.equalsIgnoreCase("Checkout")) id = "checkout";
        else if (buttonName.equalsIgnoreCase("Continue")) id = "continue";
        else if (buttonName.equalsIgnoreCase("Finish")) id = "finish";
        
        driver.findElement(By.id(id)).click();
    }

    @When("I go to the cart")
    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
    
    @When("I open the sidebar menu")
    public void openSidebar() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @When("I select the {string} option")
    public void selectSidebarOption(String optionName) {
        org.openqa.selenium.support.ui.WebDriverWait wait = 
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        
        String id = "";
        if (optionName.equalsIgnoreCase("Logout")) id = "logout_sidebar_link";
        else if (optionName.equalsIgnoreCase("Reset App State")) id = "reset_sidebar_link";
        
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}