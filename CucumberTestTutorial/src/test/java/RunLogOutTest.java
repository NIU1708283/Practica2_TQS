import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/LogOut.feature",glue = "steps")
public class RunLogOutTest extends AbstractTestNGCucumberTests {

}