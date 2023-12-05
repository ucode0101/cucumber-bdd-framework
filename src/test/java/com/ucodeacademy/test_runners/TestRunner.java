package com.ucodeacademy.test_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty", // use "pretty" if you want to see steps to be displayed on the console
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/ucodeacademy/step_definitions",
        dryRun = false,
        tags = "@test98"

)


public class TestRunner {
}
