import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/ProductDetails.feature",glue = "steps")
public class RunProductDetailsTest extends AbstractTestNGCucumberTests {

}

