import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/CheckoutMandatoryData.feature",glue = "steps")
public class RunCheckoutMandatoryDataTest extends AbstractTestNGCucumberTests {

}

