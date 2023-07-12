package com.tcs.certificacion.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateEmployeeV2 implements Task {

    private final String url;
    private final String bodyName;

    public CreateEmployeeV2(String url, String bodyName) {
        this.url = url;
        this.bodyName = bodyName;
    }

    public static CreateEmployeeV2 create(String url, String bodyName) {
        return instrumented(CreateEmployeeV2.class, url, bodyName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(bodyName);
        actor.attemptsTo(
                Post.to(url)
                        .with(rq -> rq
                                .header("Content-Type", "application/json; charset=utf-8")
                                .relaxedHTTPSValidation()
                                .body(body)
                        )
        );
        System.out.println("Response: ");
        SerenityRest.lastResponse().prettyPrint();
    }
}
