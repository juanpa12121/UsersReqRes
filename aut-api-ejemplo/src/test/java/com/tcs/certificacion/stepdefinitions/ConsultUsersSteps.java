package com.tcs.certificacion.stepdefinitions;

import com.tcs.certificacion.enums.Environment;
import com.tcs.certificacion.exceptions.GeneralException;
import com.tcs.certificacion.models.Employee;
import com.tcs.certificacion.questions.ValidateStatusCode;
import com.tcs.certificacion.tasks.ConsultUser;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.Map;
import java.util.function.Predicate;

import static com.tcs.certificacion.exceptions.GeneralException.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultUsersSteps {

    @Given("I can query the users api {string}")
    public void iCanQueryTheUsersApi(String environment) {
        theActorInTheSpotlight().whoCan(CallAnApi.at(Environment.getEnvironment(environment)));
    }

    @When("Querying user with id {int}")
    public void queryingUserWithId(int id) {
        theActorInTheSpotlight().attemptsTo(ConsultUser.getUserById(id));
    }

//    @Then("The service answers me status code {int}")
//    public void theServiceAnswersMeStatusCode(int statusCode) {
//        theActorInTheSpotlight().should(
//                seeThatResponse(
//                        res -> res.statusCode(statusCode)
//                )
//        );
//    }

    @Then("The service answers me status code {int}")
    public void theServiceAnswersMeStatusCode(int statusCode) {
        theActorInTheSpotlight().should(
                seeThat(ValidateStatusCode.code(), Matchers.equalTo(statusCode))
                        .orComplainWith(GeneralException.class, THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED )
        );
    }
}
