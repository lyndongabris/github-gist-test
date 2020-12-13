import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.gist.test.stepdefs",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        tags = {"not @wip", "@selected"}
)
public class RunSelectedTestRunner {
}
