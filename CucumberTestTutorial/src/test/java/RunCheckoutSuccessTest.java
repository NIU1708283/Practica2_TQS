import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/CheckoutSuccess.feature",glue = "steps")
public class RunCheckoutSuccessTest extends AbstractTestNGCucumberTests {

}

