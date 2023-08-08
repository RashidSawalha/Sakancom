import static org.junit.Assert.assertTrue;
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import io.cucumber.junit.CucumberOptions.SnippetType;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@modify",
        features = "use_cases",
        plugin = {"html:Target/cucumber.html"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE
)

public class Tester {

}
