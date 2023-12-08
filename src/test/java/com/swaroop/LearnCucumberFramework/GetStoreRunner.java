package com.swaroop.LearnCucumberFramework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber"},
		features = "src/test/resources/features/GetStores.feature",
		glue = {"com.stepDefinitions","com.base"},
		tags = "not @getAllStores and not @getStoreById",
		dryRun = true,
		monochrome = true
		)

public class GetStoreRunner {

}
