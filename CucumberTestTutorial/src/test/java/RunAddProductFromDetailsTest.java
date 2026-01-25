import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/AddProductFromDetails.feature",glue = "steps")
public class RunAddProductFromDetailsTest extends AbstractTestNGCucumberTests {

}