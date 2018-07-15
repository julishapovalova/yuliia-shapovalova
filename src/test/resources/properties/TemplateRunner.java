import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        dryRun = false, //запусе туестов без имплементированных
        monochrome = true,
        plugin = {"json:target/cucumber-report/1.json"}
    //    tags = {"~@ignore, @InDev"}

)
public class TemplateRunner {
    Object
}