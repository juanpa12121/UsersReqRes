package com.tcs.certificacion.models;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private TestData() {
    }
    private static Map<String, Object> dataTest = new HashMap<>();

    public static Map<String, Object> getDataTest() {
        return dataTest;
    }

    public static void setDataTest(Map<String, Object> dataTest) {
        TestData.dataTest = dataTest;
    }
}
