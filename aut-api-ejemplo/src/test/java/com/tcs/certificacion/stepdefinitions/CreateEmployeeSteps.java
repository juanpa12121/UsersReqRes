package com.tcs.certificacion.stepdefinitions;

import com.tcs.certificacion.models.TestData;
import com.tcs.certificacion.tasks.CreateBody;
import com.tcs.certificacion.tasks.CreateEmployee;
import com.tcs.certificacion.tasks.CreateEmployeeV2;
import com.tcs.certificacion.tasks.DataUpload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateEmployeeSteps {

    @Given("Upload the data test")
    public void uploadTheDataTest(List<Map<String, String>> clientData) {
        OnStage.theActorInTheSpotlight().wasAbleTo(DataUpload.theData(clientData.get(0)));
    }

    @When("I create the employee")
    public void iCreateTheEmployee() {
        //theActorInTheSpotlight().attemptsTo(CreateEmployee.create(name, job));
        theActorInTheSpotlight().attemptsTo(CreateBody.sendBody("template/create_employee.json", "create_employee", TestData.getDataTest()));
        theActorInTheSpotlight().attemptsTo(CreateEmployee.create("api/users", "create_employee" ));
    }

    //createv2
    @When("When i create the employee with the data name {string} and {string}")
    public void whenICreateTheEmployeeWithTheDataNameAnd(String name, String job) {
        theActorInTheSpotlight().attemptsTo(CreateEmployeeV2.create(name, job));
    }

    @Then("Return and validate the name {string} of employee")
    public void returnAndValidateTheNameOfEmployee(String name) {
        theActorInTheSpotlight().should(
                seeThatResponse("Valid name",
                        res -> res.body("name", Matchers.equalTo(name))
        ));
    }


}
