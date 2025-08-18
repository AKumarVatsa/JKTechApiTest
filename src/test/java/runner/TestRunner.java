package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/resource",   // ✅ Correct location
    glue = "step",                   
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
