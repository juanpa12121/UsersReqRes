package com.tcs.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.tcs.certificacion.stepdefinitions", "com.tcs.certificacion.setup.hook"},
        features = "src/test/resources/com/tcs/certificacion/features/create_employee.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@createv3",
        monochrome = true

)
public class CreateEmployeeRunner {
}
