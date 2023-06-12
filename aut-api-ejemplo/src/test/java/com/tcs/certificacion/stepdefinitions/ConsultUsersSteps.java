package com.tcs.certificacion.stepdefinitions;

import com.tcs.certificacion.tasks.ConsultUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultUsersSteps {

    @Given("I can query the users api")
    public void iCanQueryTheUsersApi() {
        theActorInTheSpotlight().whoCan(CallAnApi.at("https://reqres.in"));
    }

    @When("Querying user with id {int}")
    public void queryingUserWithId(int id) {
        theActorInTheSpotlight().attemptsTo(ConsultUser.getUserById(id));
    }

    @Then("The service answers me status code {int}")
    public void theServiceAnswersMeStatusCode(int statusCode) {
        theActorInTheSpotlight().should(
                seeThatResponse(
                        res -> res.statusCode(statusCode)
                )
        );
    }
}
