import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/ProductPriceSortingLowHigh.feature",glue = "steps")
public class RunProductPriceSortingLowHighTest extends AbstractTestNGCucumberTests {

}
