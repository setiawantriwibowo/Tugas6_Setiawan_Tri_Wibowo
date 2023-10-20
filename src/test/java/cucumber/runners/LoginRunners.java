package cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/cucumber/resources/features/login.feature",
        glue = "cucumber.stepDef",
        plugin = {"html:target/HTML_reportLogin.html"},
        tags = "@Test"

)

public class LoginRunners {
}