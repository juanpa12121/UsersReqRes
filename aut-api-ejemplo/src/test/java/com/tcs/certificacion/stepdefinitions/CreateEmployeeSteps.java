package com.tcs.certificacion.stepdefinitions;

import com.tcs.certificacion.enums.Constants;
import com.tcs.certificacion.models.Employee;
import com.tcs.certificacion.models.TestData;
import com.tcs.certificacion.tasks.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static com.tcs.certificacion.enums.Constants.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateEmployeeSteps {

    @DataTableType
    public Employee employeeEntry(Map<String, String> entry) {
        return new Employee(entry.get(NAME.getConstant()), entry.get(JOB.getConstant()));
    }

    //createv1
    @When("When i create the employee with the data name {string} and {string}")
    public void whenICreateTheEmployeeWithTheDataNameAnd(String name, String job) {
        theActorInTheSpotlight().attemptsTo(CreateEmployeeV1.create(name, job));
    }

    @Then("Return and validate the name {string} of employee")
    public void returnAndValidateTheNameOfEmployee(String name) {
        theActorInTheSpotlight().should(
                seeThatResponse((VALIDATE_MSJ.getConstant()),
                        res -> res.body((NAME.getConstant()), Matchers.equalTo(name))
                ));
    }

    //@createv2
    @Given("Upload the data test")
    public void uploadTheDataTest(List<Map<String, String>> clientData) {
        OnStage.theActorInTheSpotlight().wasAbleTo(DataUpload.theData(clientData.get(0)));
    }

    @When("I create the employee")
    public void iCreateTheEmployee() {
        //theActorInTheSpotlight().attemptsTo(CreateEmployee.create(name, job));

        theActorInTheSpotlight().attemptsTo(CreateBody.sendBody("template/create_employee.json", "create_employee", TestData.getDataTest()));
        theActorInTheSpotlight().attemptsTo(CreateEmployeeV2.create("/api/users", "create_employee"));
    }

    //@createv3
    @When("I create the employee with the data")
    public void iCreateTheEmployeeWithTheData(Employee employee) {
        theActorInTheSpotlight().attemptsTo(CreateEmployeeV3.create(employee));
    }


}
