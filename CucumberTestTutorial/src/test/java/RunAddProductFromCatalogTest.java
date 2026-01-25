import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/AddProductFromCatalog.feature",glue = "steps")
public class RunAddProductFromCatalogTest extends AbstractTestNGCucumberTests {

}
