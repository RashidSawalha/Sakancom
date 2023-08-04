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
//public static void main(String [] args){
// Admin admin=new Admin("Alaa","ala14112001");
// Worker w1,w2,w3,w4;
// w1=new Worker("Ali","Asira","1","123");
// w2=new Worker("Ahmad","Nablus","2","456");
// w3=new Worker("Fathi","Ramallah","3","789");
// w4=new Worker("Safwan","Jerusalem","4","987");
// admin.addWorker(w1);
// admin.addWorker(w2);
// admin.addWorker(w3);
// admin.addWorker(w4);
//
// admin.getWorkers();
//
// admin.deleteWorker("Ali","1");
// admin.getWorkers();

//}
}
