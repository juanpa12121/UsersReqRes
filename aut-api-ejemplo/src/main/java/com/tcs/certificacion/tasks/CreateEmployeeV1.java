package com.tcs.certificacion.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateEmployeeV1 implements Task {

    private final String name;

    private final String job;

    public CreateEmployeeV1(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public static CreateEmployeeV1 create(String name, String job){
        return Tasks.instrumented(CreateEmployeeV1.class, name, job);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users")
                        .with(rq -> rq
                                .header("Content-Type", "application/json; charset=utf-8")
                                .relaxedHTTPSValidation()
                                .body(String.format("{\"name\": \"%s\",\"job\": \"%s\"}", name, job))
                        )
        );
        System.out.println("Last response");
        SerenityRest.lastResponse().prettyPrint();
    }
}
