package org.prog.sql;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.prog.sql",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        }

)
public class MyCucumberRunner extends AbstractTestNGCucumberTests {
    }
