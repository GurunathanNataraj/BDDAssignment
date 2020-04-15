package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/GiftVoucher.feature",glue="StepDefinitions",monochrome=true)
public class GiftVoucherTestRunner {

}
