import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/RemoveProductFromCatalog.feature",glue = "steps")
public class RunRemoveProductFromCatalogTest extends AbstractTestNGCucumberTests {

}