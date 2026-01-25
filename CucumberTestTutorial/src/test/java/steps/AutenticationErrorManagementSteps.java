package steps;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class AutenticationErrorManagementSteps {
	WebDriver driver;

	@Before
	public void setup() {
		driver = CommonSteps.getDriver();
	}
}