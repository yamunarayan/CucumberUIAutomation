package com.lao.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:/features",
                   glue="com.lao.step_definitions",
                    dryRun = false,
        publish = true,
        plugin = {"pretty","rerun:target/failed_scenario.txt",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/CucmberReports/reports.html",
                "json:target/CucmberReports/reports.json",
                "junit:target/CucmberReports/reports.xml",
               "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

}



)
public class TestRunner {
}
