package com.tcs.certificacion.tasks;

import com.tcs.certificacion.models.TestData;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.Tasks;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DataUpload implements Task {
    private final Map<String, String> clientData;

    public DataUpload(Map<String, String> clientData) {
        this.clientData = clientData;
    }

    public static Performable theData(Map<String, String> datosCliente) {
        return Tasks.instrumented(DataUpload.class, datosCliente);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Set<Map.Entry<String, String>> testData = clientData.entrySet();
        TestData.setDataTest(testData.stream().
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

    }
}
