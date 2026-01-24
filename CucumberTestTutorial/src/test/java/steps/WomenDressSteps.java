package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.jupiter.api.Assertions;

public class WomenDressSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Método auxiliar para hacer clic de forma segura
	private void clickElement(WebElement element)
	{
		try
		{
			// Intenta hacer clic normal
			element.click();
		}
		catch (Exception e)
		{
			// Si falla, usa JavaScript para hacer clic
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	// Método auxiliar para hacer scroll hasta el elemento
	private void scrollToElement(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		try
		{
			Thread.sleep(500); // Pequeño retraso para que el scroll se complete
		}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}
	
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage()
	{
		// Configurar la ruta del ChromeDriver
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		// Establecer esperas implícitas y explícitas
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		// Navegar a la página
		driver.navigate().to("https://automationexercise.com");
		
		// Esperar a que la página cargue completamente
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("features_items")));
		
		// Intentar cerrar popup si existe
		try
		{
			WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(), 'Close') or @aria-label='Close']"));
			clickElement(closeButton);
		}
		catch (Exception e)
		{
			// No hay popup, continuar
		}
	}

	@When("the user clicks the products option")
	public void theUserClicksTheProductsOption()
	{
		// Esperar a que el elemento sea clickeable
		WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Products")));
		
		// Hacer scroll hasta el elemento
		scrollToElement(productsLink);
		
		// Hacer clic de forma segura
		clickElement(productsLink);
		
		// Esperar a que la página de productos cargue
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_product")));
	}
	
	@When("^the user enters (.*) in the search bar")
	public void theUserEntersDressInTheSearchBar(String article)
	{
		// Esperar a que el campo de búsqueda sea visible y presente
		WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_product")));
		
		// Hacer scroll al elemento
		scrollToElement(searchInput);
		
		// Limpiar el campo y escribir
		searchInput.clear();
		searchInput.sendKeys(article);
	}
	
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton()
	{
		// Esperar a que el botón de búsqueda sea clickeable
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_search"))).click();
	}
	
	@Then("^the (.*) list appears")
	public void theDressListAppears(String article)
	{
		String title = driver.findElement(By.className("features_items")).getText();
		Assertions.assertTrue(title.contains("SEARCHED PRODUCTS"));
	}
	
	@After
	public void tearDown()
	{
		// Cerrar el navegador después de cada escenario
		if (driver != null)
		{
			driver.quit();
		}
	}
}
