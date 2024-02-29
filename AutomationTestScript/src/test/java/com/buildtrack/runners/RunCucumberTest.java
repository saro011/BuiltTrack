package com.buildtrack.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        // tags="${cucumber.filter.tags}",
        // tags = "not @submitSimulationShingled and not @submitSimulationThinfilm and
        // not @submitSimulationHalfCell and not @submitSimulationBifacial",
        features = "src/test/resources/features/example.feature",
        glue = { "com.buildtrack.hooks", "com/buildtrack/steps" },

           monochrome = true, publish = true


)
public class RunCucumberTest extends AbstractTestNGCucumberTests {



    }