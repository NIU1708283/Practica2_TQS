import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/AutenticationErrorManagement.feature",glue = "steps")
public class RunAutenticationErrorManagementTest extends AbstractTestNGCucumberTests{
}