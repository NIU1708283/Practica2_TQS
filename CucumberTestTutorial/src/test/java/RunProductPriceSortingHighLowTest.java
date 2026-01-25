import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/ProductPriceSortingHighLow.feature",glue = "steps")
public class RunProductPriceSortingHighLowTest extends AbstractTestNGCucumberTests {

}
