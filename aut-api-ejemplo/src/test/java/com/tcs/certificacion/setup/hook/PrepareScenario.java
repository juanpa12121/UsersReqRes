package com.tcs.certificacion.setup.hook;

import com.tcs.certificacion.enums.Constants;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


import static com.tcs.certificacion.enums.Constants.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class PrepareScenario {
    @Before
    public void prepareScenario(){
        OnStage.setTheStage(new OnlineCast());
        theActor(String.valueOf(ACTOR_NAME.getConstant()));
        //Para @createv2
        String baseUrl = "https://reqres.in/";
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(baseUrl));
    }
}
