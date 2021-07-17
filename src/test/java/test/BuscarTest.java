package test;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"pretty", "html:target/cucumber-html-report"},
//        tags = {"@OnlyOneTime"},
        glue={"stepdefinitions","classpath/stepdefinitions"},
//      dryRun = true,
        monochrome = true
)


public class BuscarTest {
}
