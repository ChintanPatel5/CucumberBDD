package testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features = { "src/test/resources/AppFeatures" }, 
					glue = { "stepdefinitions", "AppHooks" },
//					tags = "@Practise",
					plugin = {
								"pretty",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"timeline:test-output-thread/",
								"rerun:target/failedrerun.txt" }, 
					monochrome = true)
public class TestngParallelRunSet extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
