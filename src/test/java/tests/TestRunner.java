package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/tests/books.feature",
    glue = {"src/test/java/tests/BookSteps.java"},
    plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json" },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
