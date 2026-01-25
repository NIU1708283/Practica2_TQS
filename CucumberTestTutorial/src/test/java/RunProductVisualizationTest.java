import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/ProductVisualization.feature",glue = "steps")
public class RunProductVisualizationTest extends AbstractTestNGCucumberTests {

}

