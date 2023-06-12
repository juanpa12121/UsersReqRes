package com.tcs.certificacion.setup.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class PrepareScenario {
    @Before
    public void prepareScenario(){
        OnStage.setTheStage(new OnlineCast());
        theActor("Administrador");
    }
}
