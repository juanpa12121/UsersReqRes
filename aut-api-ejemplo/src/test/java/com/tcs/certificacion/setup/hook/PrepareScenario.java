package com.tcs.certificacion.setup.hook;

import com.tcs.certificacion.enums.Constants;
import com.tcs.certificacion.enums.Environment;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;


import static com.tcs.certificacion.enums.Constants.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class PrepareScenario {

    private EnvironmentVariables environmentVariables;
    private String ambient;
    @Before
    public void prepareScenario(){
        ambient = environmentVariables.optionalProperty("amb").orElse("https://reqres.in");

        OnStage.setTheStage(new OnlineCast());
        theActor(String.valueOf(ACTOR_NAME.getConstant()))
                .whoCan(CallAnApi.at(Environment.getEnvironment(ambient)));
    }
}
