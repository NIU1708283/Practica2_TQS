import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/ProductNameSortingAZ.feature",glue = "steps")
public class RunProductNameSortingAZTest extends AbstractTestNGCucumberTests {

}

