package com.lao.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"@target/failed_scenario.txt"},
                   glue="com.lao.step_definitions",
        plugin = {"rerun:target/failed_scenario.txt"}


)
public class TestReRunner {
}
