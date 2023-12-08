package com.swaroop.LearnCucumberFramework;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber"},
		features = "src/test/resources/features/CreateStore.feature",
		glue = {"com.stepDefinitions","com.base"},
		tags = "@createStore",
		dryRun = false,
		monochrome = true
		)

public class CreateStoreRunner {

}
