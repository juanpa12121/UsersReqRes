package com.tcs.certificacion.tasks;

import com.tcs.certificacion.utils.templates.MergeFrom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBody implements Task {

    private final String pathJson;
    private final String nameBody;
    private final Map<String, String> dataTest;

    public CreateBody(String pathJson, String nameBody, Map<String, String> dataTest) {
        this.pathJson = pathJson;
        this.nameBody = nameBody;
        this.dataTest = dataTest;
    }

    public static CreateBody sendBody(String pathJson, String nameJson, Map<String, Object> dataTest){
        return instrumented(CreateBody.class, pathJson, nameJson, dataTest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String mensaje = MergeFrom.template(pathJson).withFieldsFrom(dataTest);
        System.out.println(mensaje);
        actor.remember(nameBody,mensaje);
    }
}
