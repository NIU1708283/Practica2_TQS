import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/LogIn.feature",glue = "steps")
public class RunLogInTest extends AbstractTestNGCucumberTests {

}

