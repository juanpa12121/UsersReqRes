package com.tcs.certificacion.tasks;

import com.tcs.certificacion.models.Employee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateEmployeeV3 implements Task {

    private Employee employee;

    public CreateEmployeeV3(Employee employee) {
        this.employee = employee;
    }

    public static CreateEmployeeV3 create(Employee employee) {
        return Tasks.instrumented(CreateEmployeeV3.class, employee);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users")
                        .with(rq -> rq
                                .header("Content-Type", "application/json; charset=utf-8")
                                .relaxedHTTPSValidation()
                                .body(employee)
                        )
        );
        System.out.println("Last response");
        SerenityRest.lastResponse().prettyPrint();
    }
}
