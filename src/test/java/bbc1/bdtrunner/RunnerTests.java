package bbc1.bdtrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/tests.feature",
        glue = "stepdefinitions"
)
public class RunnerTests {
}
