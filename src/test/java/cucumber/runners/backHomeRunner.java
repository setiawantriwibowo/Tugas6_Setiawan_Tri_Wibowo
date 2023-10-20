package cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/cucumber/resources/features/backhome.feature",
        glue = "cucumber.stepDef",
        plugin = {"html:target/HTML_reportbackhome.html"},
        tags = "@Test"
)

public class backHomeRunner {
}
