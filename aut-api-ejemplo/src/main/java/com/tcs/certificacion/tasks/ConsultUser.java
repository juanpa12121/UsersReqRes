package com.tcs.certificacion.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultUser implements Task {

    private int id;

    public ConsultUser(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users/"+id)
                        .with(requestSpecification ->
                                requestSpecification.log().all().relaxedHTTPSValidation())
        );
        System.out.println("\nResponse result");
        SerenityRest.lastResponse().prettyPrint();
    }

    public static ConsultUser getUserById(int id){
        return Tasks.instrumented(ConsultUser.class, id);
    }
}
