import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/ResetAppState.feature",glue = "steps")
public class RunResetAppStateTest extends AbstractTestNGCucumberTests {

}
