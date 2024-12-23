package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src\\main\\resources\\Features",
        glue = "StepDefinisions",
        tags = "@Smoke"
)
public class R01_runners {
}
